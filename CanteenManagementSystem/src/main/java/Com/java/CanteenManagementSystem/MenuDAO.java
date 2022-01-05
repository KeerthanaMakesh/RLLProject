package Com.java.CanteenManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Com.java.CanteenManagementSystem.ConnectionHelper;
import Com.java.CanteenManagementSystem.Menu;

public class MenuDAO {
	Connection connection;
	PreparedStatement pst;
	
	public List<Menu> showMenu() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Menu";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Menu> MenuList = new ArrayList<Menu>();
		Menu res = null; 
		while(rs.next()) {
			res = new Menu();
			res.setMenuId(rs.getInt("MenuId"));
			res.setRestaurantId(rs.getInt("RestaurantId"));
			res.setItemName(rs.getString("ItemName"));
			res.setMenuType(rs.getString("MenuType"));
			res.setCalories(rs.getInt("Calories"));
			res.setPrice(rs.getInt("Price"));
			MenuList.add(res);
		}
		return MenuList;
	}
	
	public Menu searchMenu(int MenuId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Menu where MenuId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, MenuId);
		ResultSet rs = pst.executeQuery();
		Menu menu = null;
			if (rs.next()) {
				menu= new Menu();
				menu.setMenuId(rs.getInt("MenuId"));
				menu.setRestaurantId(rs.getInt("RestaurantId"));
				menu.setItemName(rs.getString("ItemName"));
				menu.setMenuType(rs.getString("MenuType"));
				menu.setCalories(rs.getInt("Calories"));
				menu.setPrice(rs.getInt("Price"));
			}
		return menu;
	}
	
	public List<Menu> showMenu(int restaurantId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from menu where RESTAURANTID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, restaurantId);
		ResultSet rs = pst.executeQuery();
		List<Menu> menuList = new ArrayList<Menu>();
		Menu menu = null;
		while(rs.next()) {
			menu = new Menu();
			menu.setMenuId(rs.getInt("MenuId"));
			menu.setRestaurantId(rs.getInt("restaurantid"));
			menu.setItemName(rs.getString("ItemName"));
			menu.setMenuType(rs.getString("MenuType"));
			menu.setCalories(rs.getInt("Calories"));
			menu.setPrice(rs.getInt("Price"));
			menuList.add(menu);
		}
		return menuList;
	}
	
	public int generateMenuId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select max(MenuId)+1 menuid from Menu";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int MenuId = rs.getInt("menuid");
		return MenuId;
	}
	

	public String addMenu(Menu menu) throws ClassNotFoundException, SQLException {
		int menuid =generateMenuId();
		connection = ConnectionHelper.getConnection();
		menu.setMenuId(menuid);
		String cmd = "Insert into Menu(MenuId,RestaurantId,ItemName,MenuType,Calories,Price) "
				+ " values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, menu.getMenuId());
		pst.setInt(2, menu.getRestaurantId());
		pst.setString(3, menu.getItemName());
		pst.setString(4, menu.getMenuType());
		pst.setInt(5, menu.getCalories());
		pst.setInt(6, menu.getPrice());
		pst.executeUpdate();
		return "Record Inserted...";
	}
}
