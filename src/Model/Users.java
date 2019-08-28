package Model;

import java.util.Date;

public class Users extends KingModel{
	
	private String UserName;
	private String Position;
	private String ChangeUser;
	private Date ChangeRecordDate;
	private String Password;
	private int Phone;
	private String Address;
	
	
	private static String whoIs="";
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
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
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public static String getWhoIs() {
		return whoIs;
	}
	public static void setWhoIs(String whoIs) {
		Users.whoIs = whoIs;
	}
	

}
