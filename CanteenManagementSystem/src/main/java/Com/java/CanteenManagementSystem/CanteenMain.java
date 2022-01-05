package Com.java.CanteenManagementSystem;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
 

public class CanteenMain {
static Scanner sc =  new Scanner(System.in);

	
	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("O P T I O N S");
			System.out.println("---------------");
			System.out.println("1. Add Restaurant ");
			System.out.println("2. Show Restaurant ");
			System.out.println("3. Search Restaurant");
			System.out.println("4  Add Menu");
            System.out.println("5. Show Menu");
			System.out.println("6. Search Menu");
			System.out.println("7. Show Menu by RestaurantId");
			System.out.println("8.  Add Customer");
			System.out.println("9. Show Customer");
			System.out.println("10. Search Customer");
			System.out.println("11.  Add Vendor");
			System.out.println("12. Show Vendor");
			System.out.println("13. Search Vendor");
			System.out.println("14. Add Wallet");
			System.out.println("15. Show Wallet");
			System.out.println("16. Search Wallet");
			System.out.println("17. Show Wallet by CustomerId");
			System.out.println("18. Place Order ");
			System.out.println("19. Accept or Reject Orders");
			System.out.println("Enter Your Choice   ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				try {
					addRestaurant();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.err.println(e1.getMessage());
				}
				break;
			case 2 : 
				showRestaurant();
				break;
			case 3 : 
				try {
					searchRestaurant();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4: 
				try {
					addMenu();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.err.println(e1.getMessage());
				}
				break;
				
			case 5:
				showMenu();
				break;		
			case 6: 
				try {
					searchMenu();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7:
				try {
					searchMenuWithRestaurantId();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 8:
				try {
					addCustomer();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.err.println(e1.getMessage());
				}
				break;
			
			case 9:
				showCustomer();
				break;		
			case 10: 
				try {
					searchCustomer();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 11:
				try {
					addVendor();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.err.println(e1.getMessage());
				}
				break;
			case 12:
				showVendor();
				break;		
			case 13: 
				try {
					searchVendor();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 14:
				try {
					addWallet();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.err.println(e1.getMessage());
				}
				break;
			case 15:
				showWallet();
				break;		
			case 16: 
				try {
					searchWallet();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 17:
				try {
					searchWalletWithCustomerId();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 18:
				try {
					placeOrder();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 19:
				try {
					acceptOrReject();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case 20: 
				return;
			}
		} while(choice!=20);
	}
	
	public static void addRestaurant()
	{
		Restaurant rest = new Restaurant();
		System.out.println("Enter Restaurant Name ");
		rest.setRestaurantName(sc.next());
		System.out.println("Enter city ");
		rest.setCity(sc.next());
		System.out.println("Enter Branch ");
		rest.setBranch(sc.next());
		System.out.println("Enter Email ");
		rest.setEmail(sc.next());
		System.out.println("Enter ContactNo");
		rest.setContactNo(sc.next());
		RestaurantDAO dao = new RestaurantDAO();
		try {
			System.out.println(dao.addRestaurant(rest));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void searchRestaurant() throws ClassNotFoundException, SQLException {
		int rid;
		System.out.println("Enter Restaurant id   ");
		rid = sc.nextInt();
		Restaurant restaurant = new RestaurantDAO().searchRestaurant(rid);
		System.out.println(restaurant);
	}
	
	public static void showRestaurant() {
		try {
			List<Restaurant> restaurantList = new RestaurantDAO().showRestaurant();
			for (Restaurant restaurant : restaurantList) {
				System.out.println(restaurant);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addMenu() throws ClassNotFoundException, SQLException
	{
		Menu menu = new Menu();
		System.out.println("Enter Restaurant Id ");
		menu.setRestaurantId(sc.nextInt());
		System.out.println("Enter Item Name ");
		menu.setItemName(sc.next());
		System.out.println("Enter Menu Type");
		menu.setMenuType(sc.next());
		System.out.println("Enter Calories ");
		menu.setCalories(sc.nextInt());
		System.out.println("Enter Price");
		menu.setPrice(sc.nextInt());
		MenuDAO dao = new MenuDAO();
		try {
			System.out.println(dao.addMenu(menu));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void showMenu() {
		try {
			List<Menu> menuList = new MenuDAO().showMenu();
			for (Menu menu : menuList) {
				System.out.println(menu);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void searchMenu() throws ClassNotFoundException, SQLException {
		int mid;
		System.out.println("Enter Menu id   ");
		mid = sc.nextInt();
		Menu menu = new MenuDAO().searchMenu(mid);
		System.out.println(menu);
	}
	
	public static void searchMenuWithRestaurantId() {
		int restaurantId;
		System.out.println("Enter Restaurant Id");
		restaurantId = sc.nextInt();
		try {
		List<Menu> menuList = new MenuDAO().showMenu(restaurantId);
		for (Menu menu : menuList) {
			System.out.println(menu);
		}
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	}
	
	public static void addCustomer() throws ClassNotFoundException, SQLException
	{
		Customer cus = new Customer();
		System.out.println("Enter Customer Name ");
		cus.setCustomerName(sc.next());
		System.out.println("Enter city ");
		cus.setCity(sc.next());
		System.out.println("Enter State ");
		cus.setState(sc.next());
		System.out.println("Enter Email ");
		cus.setEmail(sc.next());
		System.out.println("Enter ContactNo");
		cus.setContactNo(sc.next());
		CustomerDAO dao = new CustomerDAO();
		try {
			System.out.println(dao.addCustomer(cus));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void showCustomer() {
		try {
			List<Customer> CustomerList = new CustomerDAO().showCustomer();
			for (Customer cus : CustomerList) {
				System.out.println(cus);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void searchCustomer() throws ClassNotFoundException, SQLException {
		int cid;
		System.out.println("Enter Customer id   ");
		cid = sc.nextInt();
		Customer c = new CustomerDAO().searchCustomer(cid);
		System.out.println(c);
	}
	
	public static void searchWalletWithCustomerId() {
		int customerId;
		System.out.println("Enter Customer Id");
		customerId = sc.nextInt();
		try {
		List<Wallet> walletList = new WalletDAO().showWallet(customerId);
		for (Wallet wallet : walletList) {
			System.out.println(wallet);
		}
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	}
	
	public static void addVendor() throws ClassNotFoundException, SQLException
	{
		Vendor v = new Vendor();
		System.out.println("Enter Vendor Name ");
		v.setVendorName(sc.next());
		System.out.println("Enter city ");
		v.setVendorCity(sc.next());
		System.out.println("Enter State ");
		v.setVendorState(sc.next());
		System.out.println("Enter Email ");
		v.setVendorEmail(sc.next());
		System.out.println("Enter ContactNo");
		v.setVendorContactNo(sc.next());
		VendorDAO dao = new VendorDAO();
		try {
			System.out.println(dao.addVendor(v));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void showVendor() {
		try {
			List<Vendor> VendorList = new VendorDAO().showVendor();
			for (Vendor v : VendorList) {
				System.out.println(v);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void searchVendor() throws ClassNotFoundException, SQLException {
		int vid;
		System.out.println("Enter Vendor id   ");
		vid = sc.nextInt();
		Vendor v = new VendorDAO().searchVendor(vid);
		System.out.println(v);
	}
	
	public static void addWallet() throws ClassNotFoundException, SQLException
	{
		Wallet w = new Wallet();
		System.out.println("Enter Customer Id ");
		w.setCustomerId(sc.nextInt());
		System.out.println("Enter Wallet Name ");
		w.setWalletName(sc.next());
		System.out.println("Enter Wallet Balance ");
		w.setWalletBalance(sc.nextInt());
		WalletDAO dao = new WalletDAO();
		try {
			System.out.println(dao.addWallet(w));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void showWallet() {
		try {
			List<Wallet> WalletList = new WalletDAO().showWallet();
			for (Wallet w : WalletList) {
				System.out.println(w);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void searchWallet() throws ClassNotFoundException, SQLException {
		int wid;
		System.out.println("Enter Wallet id   ");
		wid = sc.nextInt();
		Wallet w = new WalletDAO().searchWallet(wid);
		System.out.println(w);
	}
	
	public static void placeOrder() throws ClassNotFoundException, SQLException {
		Orders order = new Orders();
		System.out.println("Enter Customer Id   ");
		order.setCCustomerId(sc.nextInt());
		System.out.println("Enter Vendor Id  ");
		order.setVendorId(sc.nextInt());
		System.out.println("Enter Menu Id  ");
		order.setMenuId(sc.nextInt());
		System.out.println("Enter Wallet Id  ");
		order.setWalletId(sc.nextInt());
		System.out.println("Enter Quantity Ordered  ");
		order.setQuantity(sc.nextInt());
		System.out.println("Enter Comments  ");
		order.setComments(sc.next());
		OrdersDAO dao = new OrdersDAO();
		System.out.println(dao.placeOrder(order));
	}
	public static void acceptOrReject() throws ClassNotFoundException, SQLException {
		int VendorId;
		int OrderId;
		String Status;
		System.out.println("Enter Vendor Id   ");
		VendorId = sc.nextInt();
		System.out.println("Enter Order Id   ");
		OrderId = sc.nextInt();
		System.out.println("Enter Status   ");
		Status =sc.next();
		System.out.println(new OrdersDAO().acceptOrRejectOrder(OrderId, VendorId, Status));
	}
}
