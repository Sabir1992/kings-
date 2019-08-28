package Model;

public class Menu extends KingModel {
	
	private String UserName;
	private String ProductName;
	private String ProductType;
	private float PurchaseAmount;
	private float PaymentAmount;
	private String Description;
	
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public String toString() {
		return  ProductName ;
	}
	
	
	

}
