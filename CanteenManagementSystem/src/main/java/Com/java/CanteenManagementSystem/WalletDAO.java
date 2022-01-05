package Com.java.CanteenManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WalletDAO {
	
	Connection connection;
	PreparedStatement pst;
	
	public List<Wallet> showWallet() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Wallet";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Wallet> WalletList = new ArrayList<Wallet>();
		Wallet w = null; 
		while(rs.next()) {
			w= new Wallet();
			w.setCustomerId(rs.getInt("CustomerId"));
			w.setWalletId(rs.getInt("WalletId"));
			w.setWalletName(rs.getString("WalletName"));
			w.setWalletBalance(rs.getInt("WalletBalance"));
			WalletList.add(w);
		}
		return WalletList;
	}
	
	public List<Wallet> showWallet(int customerId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Wallet where CustomerId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, customerId);
		ResultSet rs = pst.executeQuery();
		List<Wallet> walletList = new ArrayList<Wallet>();
		Wallet wallet = null;
		while(rs.next()) {
			wallet = new Wallet();
			wallet.setWalletId(rs.getInt("WalletId"));
			wallet.setCustomerId(rs.getInt("CustomerId"));
			wallet.setWalletName(rs.getString("WalletName"));
			wallet.setWalletBalance(rs.getInt("WalletBalance"));
			walletList.add(wallet);
		}
		return walletList;
	}
	
	public String deductBalance(int walletId, int billAmount) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "update wallet set WalletBalance=WalletBalance-? where walletId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, billAmount);
		pst.setInt(2, walletId);
		pst.executeUpdate();
		return "Amount Deducted...";
	}
	
	public Wallet searchWallet(int WalletId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Wallet where WalletId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, WalletId);
		ResultSet rs = pst.executeQuery();
		Wallet w = null;
			if (rs.next()) {
				w= new Wallet();
				w.setCustomerId(rs.getInt("CustomerId"));
				w.setWalletId(rs.getInt("WalletId"));
				w.setWalletName(rs.getString("WalletName"));
				w.setWalletBalance(rs.getInt("WalletBalance"));
			}
		return w;
	}

	public int generateWalletId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select max(WalletId)+1 Wid from Wallet";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int WalletId = rs.getInt("Wid");
		return WalletId;
	}
	
	public String addWallet(Wallet w) throws ClassNotFoundException, SQLException {
		int Wid = generateWalletId();
		connection = ConnectionHelper.getConnection();
		w.setWalletId(Wid);
		String cmd = "Insert into Wallet(CustomerId,WalletId,WalletName,WalletBalance) "
				+ " values(?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, w.getCustomerId());
		pst.setInt(2, w.getWalletId());
		pst.setString(3, w.getWalletName());
		pst.setInt(4, w.getWalletBalance());
		pst.executeUpdate();
		return "Record Inserted...";
	}

}
