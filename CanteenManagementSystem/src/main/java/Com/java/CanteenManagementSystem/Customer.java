package Com.java.CanteenManagementSystem;

public class Customer {
	private int CCustomerId;
	private String CustomerName;
	private String City;
	private String State;
	private String Email;
	private String ContactNo;
	
	
	public int getCCustomerId() {
		return CCustomerId;
	}
	public void setCCustomerId(int customerId) {
		CCustomerId = customerId;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	
	
	@Override
	public String toString() {
		return "Customer [CustomerId=" + CCustomerId + ", CustomerName=" + CustomerName + ", City=" + City + ", State="
				+ State + ", Email=" + Email + ", ContactNo=" + ContactNo + "]";
	}



}
