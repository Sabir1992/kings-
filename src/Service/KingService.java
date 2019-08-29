package Service;

import java.util.List;

import javax.swing.JComboBox;

import Model.Expense;
import Model.Menu;
import Model.Sale;
import Model.Tables;
import Model.Users;

public interface KingService {
	
	
    List<Menu> getMenuList() throws Exception;
	
	boolean addMenu(Menu menu) throws Exception;
	
	Menu getMenuByName(String ProductName) throws Exception;
	
	boolean updateMenu(Menu menu, long id) throws Exception;
	
	List<Menu> searchMenuData(String keyword) throws Exception;
	
	boolean deleteMenu(long id) throws Exception;
	
	List<Menu>  comboadd(String productType) throws Exception;

	
	
	List<Users> getUserList() throws Exception;
	
	boolean addUser(Users user) throws Exception;
	
    Users getUserById(int UserId)throws Exception;
	
	boolean updateUser(Users user) throws Exception;
	
	

	List<Expense> getExpenseList() throws Exception;
	
	boolean addExpense(Expense ex) throws Exception;
	
	boolean updateExpense(Expense ex) throws Exception;
	
	boolean deleteExpense(String expenceType) throws Exception;
	
	

	List<Sale> getSaleList() throws Exception;

	Sale getSaleByName(String ProductName) throws Exception;

	boolean updateSale(Sale sale, String productName) throws Exception;

	boolean deleteSale(String productName) throws Exception;
	
	

	boolean addTable(Tables tables) throws Exception;

	boolean updateTable(Tables tables, long id) throws Exception;

	List<Tables> getTableList() throws Exception;

}
