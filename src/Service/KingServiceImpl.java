package Service;

import java.util.List;

import javax.swing.JComboBox;

import DaoImplClass.TableDaoImpl;
import DaoInterface.ExpenseDao;
import DaoInterface.SaleDao;
import DaoInterface.TableDao;
import DaoInterface.MenuDao;
import DaoInterface.UserDao;
import Model.Expense;
import Model.Menu;
import Model.Sale;
import Model.Tables;
import Model.Users;

public class KingServiceImpl implements KingService {

	private SaleDao saleDao;
	private MenuDao menuDao;
	private UserDao userDao;
	private ExpenseDao expenseDao;
	private TableDao tableDao;

	public KingServiceImpl(SaleDao saleDao) {
		this.saleDao = saleDao;
	}

	public KingServiceImpl(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public KingServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public KingServiceImpl(ExpenseDao expenseDao) {
		this.expenseDao = expenseDao;
	}
	
	public KingServiceImpl(TableDao tableDao) {
		this.tableDao = tableDao;
	}

	@Override
	public List<Menu> getMenuList() throws Exception {
		return menuDao.getMenuList();
	}

	@Override
	public List<Menu> searchMenuData(String keyword) throws Exception {
		return menuDao.searchMenuData(keyword);
	}

	@Override
	public boolean deleteMenu(long id) throws Exception {
		return menuDao.deleteMenu(id);
	}

	@Override
	public boolean addMenu(Menu menu) throws Exception {
		return menuDao.addMenu(menu);
	}

	@Override
	public Menu getMenuByName(String productName) throws Exception {
		return menuDao.getMenuByName(productName);
	}

	@Override
	public boolean updateMenu(Menu menu, long id) throws Exception {
		return menuDao.updateMenu(menu, id);
	}
	
	@Override
	public List<Menu>  comboadd(String productType) throws Exception {
		return menuDao.comboadd(productType);
	}

	// -----------------------------------------------------------------------------------

	@Override
	public List<Users> getUserList() throws Exception {
		return userDao.getUserList();
	}

	@Override
	public Users getUserById(int UserId) throws Exception {
		return userDao.getUserById(UserId);
	}

	@Override
	public boolean updateUser(Users user) throws Exception {
		return userDao.updateUser(user);
	}

	@Override
	public boolean addUser(Users user) throws Exception {
		return userDao.addUser(user);
	}

	// -----------------------------------------------------------------------------------

	@Override
	public List<Expense> getExpenseList() throws Exception {
		return expenseDao.getExpenseList();
	}

	@Override
	public boolean addExpense(Expense ex) throws Exception {
		return expenseDao.addExpense(ex);
	}

	@Override
	public boolean updateExpense(Expense ex) throws Exception {
		return expenseDao.updateExpense(ex);
	}

	@Override
	public boolean deleteExpense(String expenceType) throws Exception {
		return expenseDao.deleteExpense(expenceType);
	}

	// -----------------------------------------------------------------------------------

	@Override
	public List<Sale> getSaleList() throws Exception {
		return saleDao.getSaleList();
	}

	@Override
	public Sale getSaleByName(String ProductName) throws Exception {
		return saleDao.getSaleByName(ProductName);
	}

	@Override
	public boolean updateSale(Sale sale, String productName) throws Exception {
		return saleDao.updateSale(sale, productName);
	}

	@Override
	public boolean deleteSale(String productName) throws Exception {
		return saleDao.deleteSale(productName);
	}

	
	// -----------------------------------------------------------------------------------
	
	@Override
	public boolean addTable(Tables tables) throws Exception {
		return tableDao.addTable(tables);
	}

	@Override
	public boolean updateTable(Tables tables, long id) throws Exception {
		return tableDao.updateTable(tables, id);
	}

	@Override
	public List<Tables> getTableList() throws Exception {
		return tableDao.getTableList();
	}
	
	// -----------------------------------------------------------------------------------

	

}
