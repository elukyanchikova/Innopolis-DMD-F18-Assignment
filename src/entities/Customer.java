package entities;

public class Customer {
	private String Username;
	private String CustomerName;
	private String CustomerPhone;
	private String CustomerEmail;
	private String PaymentInfo;
	private Residence CustomerResidence;

	public Customer(String username, String customerName, String customerPhone, String customerEmail, String paymentInfo, Residence customerResidence) {
		setUsername(username);
		setCustomerName(customerName);
		setCustomerPhone(customerPhone);
		setCustomerEmail(customerEmail);
		setPaymentInfo(paymentInfo);
		setCustomerResidence(customerResidence);
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerPhone() {
		return CustomerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		CustomerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return CustomerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}

	public String getPaymentInfo() {
		return PaymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		PaymentInfo = paymentInfo;
	}

	public Residence getCustomerResidence() {
		return CustomerResidence;
	}

	public void setCustomerResidence(Residence customerResidence) {
		CustomerResidence = customerResidence;
	}
}
