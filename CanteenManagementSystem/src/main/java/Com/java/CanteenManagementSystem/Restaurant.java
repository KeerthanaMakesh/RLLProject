package Com.java.CanteenManagementSystem;

public class Restaurant {
	private int RestaurantId;
	private String RestaurantName;
	private String City;
	private String Branch;
	private String Email;
	private String ContactNo;
	
	
	
	public int getRestaurantId() {
		return RestaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		RestaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return RestaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		RestaurantName = restaurantName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
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
		return "Restaurant [RestaurantId=" + RestaurantId + ", RestaurantName=" + RestaurantName + ", City=" + City
				+ ", Branch=" + Branch + ", Email=" + Email + ", ContactNo=" + ContactNo + "]";
	}
	
	
	
}
