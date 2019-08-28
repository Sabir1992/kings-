package Service;

import DaoInterface.SaleDao;
import DaoInterface.LoginDao;
import Model.Users;

public class LoginServiceImpl implements LoginService{
	
	private LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
	public Users login(String username, String password,String position) throws Exception {
		return loginDao.login(username, password,position);
	}

}
