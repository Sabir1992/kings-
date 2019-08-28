package DaoInterface;

import java.util.List;

import javax.swing.JComboBox;

import Model.Menu;

public interface MenuDao {
	
    List<Menu> getMenuList() throws Exception;
	
	boolean addMenu(Menu menu) throws Exception;
	
	Menu getMenuByName(String ProductName) throws Exception;
	
	boolean updateMenu(Menu menu, long id) throws Exception;
	
	boolean deleteMenu(long id) throws Exception;
	
	List<Menu> searchMenuData(String keyword) throws Exception;
	
	List<Menu>  comboadd(String productType) throws Exception;

}
