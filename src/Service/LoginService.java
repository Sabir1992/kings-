package Service;

import Model.Users;

public interface LoginService {
	
	Users login(String username,String password,String position) throws Exception;

}
