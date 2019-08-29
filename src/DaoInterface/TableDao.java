package DaoInterface;

import java.util.ArrayList;
import java.util.List;

import Model.Tables;

public interface TableDao {
	
	boolean addTable(Tables tables) throws Exception;
	
	boolean updateTable(Tables tables, long id) throws Exception;
	
	List<Tables>   getTableList() throws Exception;

}
