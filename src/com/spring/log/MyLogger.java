package com.spring.log;


import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogger {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.spring.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.spring.das.*.*(..))")
	private void forDASPackage() {}
	
	@Pointcut("execution(* com.spring.manager.*.*(..))")
	private void forManagerPackage() {}

	@Pointcut("forControllerPackage() || forDASPackage() || forManagerPackage()")
	private void forAppFlow() {}
	
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info(" \n\n @Before calling: "+method);
	}
	
	@AfterReturning(pointcut="forAppFlow()",returning="result")
	public void afterReturning(JoinPoint theJoinPoint,Object result) {
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info(" \n\n @Before calling: "+method);
		
		myLogger.info("\n result: "+result);
	}
}
