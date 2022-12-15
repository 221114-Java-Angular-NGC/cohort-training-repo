package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static Logger log = Logger.getLogger(LoggingAspect.class);
	
	//@Before(value="execution(* com.revature.services.UserServiceImpl.getAllUsers(..))")
	@Before(value="execution(* com.revature.*.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		log.info(String.format("Before advice for: [ %s : %s ]", 
				joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName()));
	}
	
	@After(value="execution(* com.revature.*.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		log.info(String.format("After advice for: [ %s : %s ]", 
				joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName()));
	}
	
	@Around(value="execution(* com.revature.services.*.*(..))")
	public Object logDuring(ProceedingJoinPoint joinPoint) {
		//1. get the arguments returned from the dao layer call that came into the service layer (aka our list)
		Object[] args = joinPoint.getArgs();
		
		//2. provide a log message for this advice
		log.info(String.format("Around advice for: [ %s : %s ]", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName()));
		
		//3. proceed the program flow in this joinPoint's owner method by using the proceed()
		Object result = null;
		
		try {
			result = joinPoint.proceed(args);
			log.info(String.format("Results of this method invoking/proceeding is: %s", result));
		} catch (Throwable e) {
			log.warn(String.format("Unable to execute around advice: %s", e.getMessage()));
		}
		
		//4. end the advice by returning the found results from proceeding
		log.info("End of Around Advice");
		return result;
	}
}
