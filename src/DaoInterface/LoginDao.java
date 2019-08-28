package DaoInterface;

import Model.Users;

public interface LoginDao {
	
	Users login(String username,String password,String position) throws Exception;

}
