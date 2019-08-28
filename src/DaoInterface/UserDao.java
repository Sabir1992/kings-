package DaoInterface;

import java.util.List;

import Model.Users;

public interface UserDao {
	
    List<Users> getUserList() throws Exception;
	
	boolean addUser(Users user) throws Exception;
	
    Users getUserById(int UserId)throws Exception;
	
	boolean updateUser(Users user) throws Exception;

}
