package Com.java.CanteenManagementSystem;

import java.util.Date;

public class Orders {
	private int OrderId;
	private int MenuId;
	private int VendorId;
	private int CCustomerId;
	private int WalletId;
	private Date OrderDate;
	private String OrderStatus;
	private int Quantity;
	private int BillAmount;
	private String Comments;
	
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getMenuId() {
		return MenuId;
	}
	public void setMenuId(int menuId) {
		MenuId = menuId;
	}
	
	public int getVendorId() {
		return VendorId;
	}
	public void setVendorId(int vendorId) {
		VendorId = vendorId;
	}
	public int getCCustomerId() {
		return CCustomerId;
	}
	public void setCCustomerId(int CCustomerId) {
		CCustomerId = CCustomerId;
	}
	public int getWalletId() {
		return WalletId;
	}
	public void setWalletId(int walletId) {
		WalletId = walletId;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public String getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getBillAmount() {
		return BillAmount;
	}
	public void setBillAmount(int billAmount) {
		BillAmount = billAmount;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	
	
	@Override
	public String toString() {
		return "Orders [OrderId=" + OrderId + ", MenuId=" + MenuId + ", VendorId=" + VendorId + ", CCustomerId="
				+ CCustomerId + ", WalletId=" + WalletId + ", OrderDate=" + OrderDate + ", OrderStatus=" + OrderStatus
				+ ", Quantity=" + Quantity + ", BillAmount=" + BillAmount + ", Comments=" + Comments + "]";
	}
	
	

}
