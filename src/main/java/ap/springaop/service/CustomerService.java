package ap.springaop.service;

import org.springframework.stereotype.Component;


@Component("service")
public class CustomerService implements CustomerServiceInterface {

	@Override
	public void addCustomer() {		
		System.out.println("## addCustomer() running ###");		
	}

	@Override
	public String addCustomerReturnVale() {
		System.out.println("## addCustomerReturnVale() running ###");		
		return "Intercepted returning value";
	}

	@Override
	public void addCustomerAfterThrow() throws Exception {
		System.out.println("## addCustomerReturnVale() running ###");	
		throw new Exception("### Generic error : Program throws exception ###");
	}

	@Override
	public void addCustomerAround(String name) {
		System.out.println("## addCustomerAround() running ### where args are: "+name);	
	}
}
