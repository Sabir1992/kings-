package MainClass;

import DaoImplClass.ExpenseDaoImpl;
import DaoImplClass.SaleDaoImpl;
import DaoInterface.ExpenseDao;
import DaoInterface.SaleDao;
import GUI.LoginFrame;
import Service.KingService;
import Service.KingServiceImpl;

public class MainClass {

	public static void main(String[] args) {
		try {
			LoginFrame frame=new LoginFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		  }
		
	}
}
