package Com.java.CanteenManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrdersDAO {
	Connection connection;
	PreparedStatement pst;
	
	public Orders searchOrder(int OrderId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Orders where  OrderId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, OrderId);
		ResultSet rs = pst.executeQuery();
		Orders orderFound = null;
		if (rs.next()) {
			orderFound = new Orders();
			orderFound.setOrderId(rs.getInt("OrderId"));
			orderFound.setMenuId(rs.getInt("MenuId"));
			orderFound.setVendorId(rs.getInt("VendorId"));
			orderFound.setCCustomerId(rs.getInt("CCustomerId"));
			orderFound.setWalletId(rs.getInt("WalletId"));
			orderFound.setBillAmount(rs.getInt("BillAmount"));
			orderFound.setComments(rs.getString("Comments"));
			orderFound.setOrderDate(rs.getDate("OrderDate"));
			orderFound.setOrderStatus(rs.getString("OrderStatus"));
			orderFound.setQuantity(rs.getInt("Quantity"));
		}
		return orderFound;
	}
	public String acceptOrRejectOrder(int OrderId, int VendorId, String Status) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		Orders order = searchOrder(OrderId);
		if (order.getVendorId()==VendorId) {
			if (Status.toUpperCase().equals("YES")) {
				String cmd = "Update Orders set OrderStatus='ACCEPTED' "
						+ " WHERE OrderId=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, OrderId);
				pst.executeUpdate();
				return "Order Approved Successfully...";
			} else {
				String cmd = "Update Orders set OrderStatus='REJECTED' "
						+ " WHERE OrderId=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, OrderId);
				pst.executeUpdate();
				cmd = "Update Wallet set WalletBalance=WalletBalance+? where WalletId=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, order.getBillAmount());
				pst.setInt(2, order.getWalletId());
				pst.executeUpdate();
				return "Order Rejected Amount Refunded...";
			}
		} 
		return "You are unauthorized vendor...";
	}
	public String placeOrder(Orders order) throws SQLException, ClassNotFoundException {
		int oid = generateOrderId();
		order.setOrderStatus("PENDING");
		java.util.Date today = new Date();
		java.sql.Date dbDate = new java.sql.Date(today.getTime());
		order.setOrderDate(dbDate);
		Menu menu = new MenuDAO().searchMenu(order.getMenuId());
		int price = menu.getPrice();
		int  billAmount = order.getQuantity() * price;
		Wallet wallet = new WalletDAO().searchWallet(order.getWalletId());
		int amount = wallet.getWalletBalance();
		if (amount - billAmount > 0) {
			order.setBillAmount(billAmount);
			order.setOrderId(oid);
			String cmd = "insert into Orders(OrderId,VendorId,CCustomerId,MenuID,"
					+ "WalletId,OrderDate,Quantity,OrderStatus,BillAmount,Comments) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, order.getOrderId());
			pst.setInt(2, order.getVendorId());
			pst.setInt(3, order.getCCustomerId());
			pst.setInt(4, order.getMenuId());
			pst.setInt(5, order.getWalletId());
			pst.setDate(6,(java.sql.Date) order.getOrderDate()); 
			pst.setInt(7, order.getQuantity());
			pst.setString(8, order.getOrderStatus());
			pst.setInt(9, order.getBillAmount());
			pst.setString(10, order.getComments());
			pst.executeUpdate();
			new WalletDAO().deductBalance(order.getWalletId(), billAmount);
			return "Order Placed Successfully...Wallet Balance Deducted...";
		}
		return "Insufficient Funds...";
		//order.setBillAmount(billAmount);
	}
	
	public int generateOrderId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(OrderId) is NULL THEN 1"
				+ " else max(OrderId)+1 end oid from Orders";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int id = rs.getInt("oid");
		return id;
	}

}
