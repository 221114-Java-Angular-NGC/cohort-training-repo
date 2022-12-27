package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 *  Cross Cutting Concern:
 *  	CCC is "meta" logic that an application needs, it is indpendent of the business logic. 
 *  	
 *  	Examples: Logging, Exception handling, security, caching, etc . 
 *  
 *  Aspect
 *  	An Aspect is a modularization of Cross Cutting concerns. Rather than dealing with CCC across 
 *  	all of your classes/modules/layers, we have one class that deals with them all - this is an Aspect 
 *  	Inside of JAva, it takes the form of a class. You can also think of it as a collection of ADVICES. 
 *  
 *  Advice 
 *  	An advice is an action taken by an Aspect. In Spring AOP, an advice is triggered by a method invocation. 
 *  	An advice also takes the form of a method. 
 *  
 *  JoinPoint 
 *  	JP are the possible points during runtime where an advice can be invoked. (i.e. method invokations)
 *  	JP take the form of an object that is injected into advices in Spring AOP. The object itself can 
 *  		contain information about the method that is being interupted. 
 *  
 *  PointCut Expression 
 *  	Are a subset of JP, expressions taht we use to select a subset of joinpoints. 
 *  	pointcuts take the form of an expression - that we include in the advice annotation. 
 */

@Component
@Aspect
public class AspectExample {
	
//	@Before("execution(* *(..))") //this expression will target every invokation 
	@Before("execution(* com.revature.service.FruitService.*(..))") 
//	@Before("execution(* com.revature.service.FruitService.*(*,int,String))") //methods with 3 arguments, any, int String
//	@Before("execution(double com.revature.service.FruitService.*(...))") // methods with double 
	public void beforeMethod() { //this is a before adivce 
		System.out.println("Print this out before a method is invoked!");
	}
	
	
	@Before("execution(double com.revature.service.FruitService.*(..))")
	public void anotherBeforeAdvice() {
		System.out.println("Advicing before any FruiService method which returns a double");
	}
	
	@After("execution(* com.revature.service.FruitService.*(..))")
	public void afterAdvices(JoinPoint jp) { //We can grab information from the method itself. 
		System.out.println("After advice");
		if(jp.getArgs().length != 0) {
			System.out.println(jp.getArgs()[0]);
		}
	}
	
	/*
	 * Around is the most powerful kind of advice. It can control variables inside the methods and choose
	 * 	how to act based on that information . 
	 * 	e.g. It can halt methods from ever executing their logic. 
	 */
	@Around("execution(void com.revature.service.FruitService.*(..))")
	public void allAround(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("-----------");
		System.out.println("Before everything in the FruitService class");
		
		pjp.proceed(); //this target method won't execute it's logic until .proceed() has been called. 
		
		System.out.println("After everything");
		System.out.println("-----------");
		
	}
	
	
	//There are also other types of Advices we can have 
//	@AfterReturning
//	@AfterThrowing
		

}
