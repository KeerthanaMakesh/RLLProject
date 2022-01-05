package Com.java.CanteenManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerDAO {
	Connection connection;
	PreparedStatement pst;
	
	public List<Customer> showCustomer() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Customer> CustomerList = new ArrayList<Customer>();
		Customer cus = null; 
		while(rs.next()) {
			cus= new Customer();
			cus.setCCustomerId(rs.getInt("CCustomerId"));
			cus.setCustomerName(rs.getString("CustomerName"));
			cus.setCity(rs.getString("City"));
			cus.setState(rs.getString("State"));
			cus.setEmail(rs.getString("Email"));
			cus.setContactNo(rs.getString("ContactNo"));
			CustomerList.add(cus);
		}
		return CustomerList;
	}
	
	public Customer searchCustomer(int CCustomerId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer where CCustomerId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, CCustomerId);
		ResultSet rs = pst.executeQuery();
		Customer cus = null;
			if (rs.next()) {
				cus= new Customer();
				cus.setCCustomerId(rs.getInt("CCustomerId"));
				cus.setCustomerName(rs.getString("CustomerName"));
				cus.setCity(rs.getString("City"));
				cus.setState(rs.getString("State"));
				cus.setEmail(rs.getString("Email"));
				cus.setContactNo(rs.getString("ContactNo"));
			}
		return cus;
	}

	public int generateCCustomerId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select max(CCustomerId)+1 Cid from Customer";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int CCustomerId = rs.getInt("Cid");
		return CCustomerId;
	}
	
	public String addCustomer(Customer cus) throws ClassNotFoundException, SQLException {
		int Cid = generateCCustomerId();
		connection = ConnectionHelper.getConnection();
		cus.setCCustomerId(Cid);
		String cmd = "Insert into Customer(CCustomerId,CustomerName,City,State,Email,ContactNo) "
				+ " values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, cus.getCCustomerId());
		pst.setString(2, cus.getCustomerName());
		pst.setString(3, cus.getCity());
		pst.setString(4, cus.getState());
		pst.setString(5, cus.getEmail());
		pst.setString(6, cus.getContactNo());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	

}
