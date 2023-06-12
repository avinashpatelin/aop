package ap.springaop.myconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;


@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"ap.springaop"})
public class MyConfiguration {

}
