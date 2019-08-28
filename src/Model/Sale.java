package Model;

public class Sale extends KingModel{
	
	private String UserName;
	private String ProductName;
	private String ProductType;
	private float PurchaseAmount;
	private float PaymentAmount;
	private float Count;
	private float Total;
	private String TableNumber;
	private float Income;
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductType() {
		return ProductType;
	}
	public void setProductType(String productType) {
		ProductType = productType;
	}
	public float getPurchaseAmount() {
		return PurchaseAmount;
	}
	public void setPurchaseAmount(float purchaseAmount) {
		PurchaseAmount = purchaseAmount;
	}
	public float getPaymentAmount() {
		return PaymentAmount;
	}
	public void setPaymentAmount(float paymentAmount) {
		PaymentAmount = paymentAmount;
	}
	public float getCount() {
		return Count;
	}
	public void setCount(float count) {
		Count = count;
	}
	public float getTotal() {
		return Total;
	}
	public void setTotal(float total) {
		Total = total;
	}
	public String getTableNumber() {
		return TableNumber;
	}
	public void setTableNumber(String tableNumber) {
		TableNumber = tableNumber;
	}
	public float getIncome() {
		return Income;
	}
	public void setIncome(float income) {
		Income = income;
	}
	
	

}
