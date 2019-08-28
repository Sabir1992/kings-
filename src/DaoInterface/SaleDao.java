package DaoInterface;

import java.util.List;

import Model.Expense;
import Model.Menu;
import Model.Sale;
import Model.Users;

public interface SaleDao {
	
	List<Sale> getSaleList() throws Exception;
	
	Sale getSaleByName(String ProductName) throws Exception;
	
	boolean updateSale(Sale sale, String productName) throws Exception;
	
	boolean deleteSale(String productName) throws Exception;
	
}
