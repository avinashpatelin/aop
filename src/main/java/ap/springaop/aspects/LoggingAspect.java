package ap.springaop.aspects;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component("asp")
public class LoggingAspect {
	
	@Before("execution(* ap.springaop.service.CustomerService.addCustomer(..))")
	public void logBefore(JoinPoint joinpoint) {
		log.info("@@ logBefore is running ##");
		log.info("join point is running before request method: "+joinpoint.getSignature().getName());
	}
	
	@After("execution(* ap.springaop.service.CustomerService.addCustomer(..))")
	public void logAfter(JoinPoint joinpoint) {
		log.info("## logAfter is running ##");
		log.info("join point is running after request method: "+joinpoint.getSignature().getName());
	}
	
	@AfterReturning(pointcut="execution(* ap.springaop.service.CustomerService.addCustomerReturnVale(..))",returning="result")
	public void logAfterReturning(JoinPoint joinpoint,Object result) {
		log.info("## logAfterReturning is running ##");
		log.info("join point is running logAfterReturning request method: "+joinpoint.getSignature().getName());
		log.info(" method returned value is :"+result);
	}
	
	@AfterThrowing(pointcut="execution(* ap.springaop.service.CustomerService.addCustomerAfterThrow(..))",throwing="error")
	public void logAfterThrow(JoinPoint joinpoint, Throwable error) {
		log.info("## logAfter is running ##");
		log.info("join point is running after request method: "+joinpoint.getSignature().getName());
	}
	
	@Around("execution(* ap.springaop.service.CustomerService.addCustomerAround(..))")
	public void logAround(ProceedingJoinPoint pjp) throws Throwable{
		log.info("## logAround is running ##");
		log.info("join point is running after request method: "+pjp.getSignature().getName());		
		log.info("Method Arguments: "+Arrays.toString(pjp.getArgs()));
		
		log.info("## logAround is initiating requested method to proceed for execution ##");
		pjp.proceed();
		log.info("## logAround is got back control to execute after requested method execution ##");		
	}
}
