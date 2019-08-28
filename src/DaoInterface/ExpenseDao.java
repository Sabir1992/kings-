package DaoInterface;

import java.util.List;

import Model.Expense;

public interface ExpenseDao {
	
	List<Expense> getExpenseList() throws Exception;
	
	boolean addExpense(Expense ex) throws Exception;
	
	boolean updateExpense(Expense ex) throws Exception;
	
	boolean deleteExpense(String expenceType) throws Exception;


}
