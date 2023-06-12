package ap.springaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ap.springaop.myconfig.MyConfiguration;
import ap.springaop.service.CustomerServiceInterface;

/**
 * Hello world!
 *
 */

public class App {
	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(MyConfiguration.class);		
		CustomerServiceInterface service= (CustomerServiceInterface) context.getBean("service");		
		
		service.addCustomer();
		service.addCustomerReturnVale();
		service.addCustomerAround("Some message");	
		
//		try {
//			service.addCustomerAfterThrow();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

	}
}
