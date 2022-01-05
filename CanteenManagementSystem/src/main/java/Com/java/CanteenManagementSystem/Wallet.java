package Com.java.CanteenManagementSystem;

public class Wallet {
	private int CustomerId;
	private int WalletId;
	private String WalletName;
	private int WalletBalance;
	
	
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public int getWalletId() {
		return WalletId;
	}
	public void setWalletId(int walletId) {
		WalletId = walletId;
	}
	public String getWalletName() {
		return WalletName;
	}
	public void setWalletName(String walletName) {
		WalletName = walletName;
	}
	public int getWalletBalance() {
		return WalletBalance;
	}
	public void setWalletBalance(int walletBalance) {
		WalletBalance = walletBalance;
	}
	
	
	@Override
	public String toString() {
		return "Wallet [CustomerId=" + CustomerId + ", WalletId=" + WalletId + ", WalletName=" + WalletName
				+ ", WalletBalance=" + WalletBalance + "]";
	}
	

}
