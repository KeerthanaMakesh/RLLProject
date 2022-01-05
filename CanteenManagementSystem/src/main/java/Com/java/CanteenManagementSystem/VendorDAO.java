package Com.java.CanteenManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {
	Connection connection;
	PreparedStatement pst;
	
	public List<Vendor> showVendor() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Vendor";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Vendor> VendorList = new ArrayList<Vendor>();
		Vendor v = null; 
		while(rs.next()) {
			v= new Vendor();
			v.setVendorId(rs.getInt("VendorId"));
			v.setVendorName(rs.getString("VendorName"));
			v.setVendorCity(rs.getString("VendorCity"));
			v.setVendorState(rs.getString("VendorState"));
			v.setVendorEmail(rs.getString("VendorEmail"));
			v.setVendorContactNo(rs.getString("VendorContactNo"));
			VendorList.add(v);
		}
		return VendorList;
	}
	
	public Vendor searchVendor(int VendorId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Vendor where VendorId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, VendorId);
		ResultSet rs = pst.executeQuery();
		Vendor v = null;
			if (rs.next()) {
				v= new Vendor();
				v.setVendorId(rs.getInt("VendorId"));
				v.setVendorName(rs.getString("VendorName"));
				v.setVendorCity(rs.getString("VendorCity"));
				v.setVendorState(rs.getString("VendorState"));
				v.setVendorEmail(rs.getString("VendorEmail"));
				v.setVendorContactNo(rs.getString("VendorContactNo"));
			}
		return v;
	}
	
	public int generateVendorId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select max(VendorId)+1 vid from Vendor";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int VendorId = rs.getInt("vid");
		return VendorId;
	}
	
	public String addVendor(Vendor v) throws ClassNotFoundException, SQLException {
		int vid = generateVendorId();
		connection = ConnectionHelper.getConnection();
		v.setVendorId(vid);
		String cmd = "Insert into Vendor(VendorId,VendorName,VendorCity,VendorState,VendorEmail,VendorContactNo) "
				+ " values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, v.getVendorId());
		pst.setString(2, v.getVendorName());
		pst.setString(3, v.getVendorCity());
		pst.setString(4, v.getVendorState());
		pst.setString(5, v.getVendorEmail());
		pst.setString(6, v.getVendorContactNo());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	

}
