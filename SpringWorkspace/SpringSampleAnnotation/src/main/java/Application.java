import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dummy.service.CustomerService;

public class Application {

	public static void main(String[] args) {

		ApplicationContext appContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService=appContext.getBean("customerService",CustomerService.class);
		System.out.println(customerService.findAll().get(0).getFirstname());
	}

}
