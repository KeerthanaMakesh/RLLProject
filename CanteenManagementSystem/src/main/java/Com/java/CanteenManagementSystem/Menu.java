package Com.java.CanteenManagementSystem;

public class Menu {
	private int MenuId;
	private int RestaurantId;
	private String ItemName;
	private String MenuType;
	private int Calories;
	private int Price;
	
	
	
	public int getMenuId() {
		return MenuId;
	}
	public void setMenuId(int menuId) {
		MenuId = menuId;
	}
	public int getRestaurantId() {
		return RestaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		RestaurantId = restaurantId;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getMenuType() {
		return MenuType;
	}
	public void setMenuType(String menuType) {
		MenuType = menuType;
	}
	public int getCalories() {
		return Calories;
	}
	public void setCalories(int calories) {
		Calories = calories;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	
	
	@Override
	public String toString() {
		return "Menu [MenuId=" + MenuId + ", RestaurantId=" + RestaurantId + ", ItemName=" + ItemName + ", MenuType="
				+ MenuType + ", Calories=" + Calories + ", Price=" + Price + "]";
	}
	
	

}
