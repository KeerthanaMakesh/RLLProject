package Com.java.CanteenManagementSystem;

public class Vendor {
	private int VendorId;
	private String VendorName;
	private String VendorCity;
	private String VendorState;
	private String VendorEmail;
	private String VendorContactNo;
	
	
	public int getVendorId() {
		return VendorId;
	}
	public void setVendorId(int vendorId) {
		VendorId = vendorId;
	}
	public String getVendorName() {
		return VendorName;
	}
	public void setVendorName(String vendorName) {
		VendorName = vendorName;
	}
	public String getVendorCity() {
		return VendorCity;
	}
	public void setVendorCity(String vendorCity) {
		VendorCity = vendorCity;
	}
	public String getVendorState() {
		return VendorState;
	}
	public void setVendorState(String vendorState) {
		VendorState = vendorState;
	}
	public String getVendorEmail() {
		return VendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		VendorEmail = vendorEmail;
	}
	public String getVendorContactNo() {
		return VendorContactNo;
	}
	public void setVendorContactNo(String vendorContactNo) {
		VendorContactNo = vendorContactNo;
	}
	
	
	@Override
	public String toString() {
		return "Vendor [VendorId=" + VendorId + ", VendorName=" + VendorName + ", VendorCity=" + VendorCity
				+ ", VendorState=" + VendorState + ", VendorEmail=" + VendorEmail + ", VendorContactNo="
				+ VendorContactNo + "]";
	}
	
	

}
