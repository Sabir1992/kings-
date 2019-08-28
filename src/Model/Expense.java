package Model;

import java.util.Date;

public class Expense extends KingModel{
	
	private String UserName;
	private String ExpenseType;
	private float Amount;
	private String ChangeUser;
	private Date ChangeRecordDate;
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getExpenseType() {
		return ExpenseType;
	}
	public void setExpenseType(String expenseType) {
		ExpenseType = expenseType;
	}
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
	}
	public String getChangeUser() {
		return ChangeUser;
	}
	public void setChangeUser(String changeUser) {
		ChangeUser = changeUser;
	}
	public Date getChangeRecordDate() {
		return ChangeRecordDate;
	}
	public void setChangeRecordDate(Date changeRecordDate) {
		ChangeRecordDate = changeRecordDate;
	}

}
