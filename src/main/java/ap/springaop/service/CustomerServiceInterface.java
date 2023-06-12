package ap.springaop.service;

public interface CustomerServiceInterface {
	
	void addCustomer();
	
	String addCustomerReturnVale();
	
	void addCustomerAfterThrow() throws Exception;
	
	void addCustomerAround(String name);

}
