package com.in28minutes.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//Pointcut - When?
	// execution(* PACKAGE.*.*(..))
	@Before("execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))")//WHEN
	public void logMethodCall(JoinPoint joinPoint) {
		logger.info("Before Aspect - {} is called with arguments: {}"
				,  joinPoint, joinPoint.getArgs());//WHAT
	}
	
	// after called wether or not exception is thrown
	@After("execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))")//WHEN
	public void logMethodCallAfterExecution(JoinPoint joinPoint) {
		logger.info("After Aspect - {} has executed"
				,  joinPoint);//WHAT
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))",
			throwing = "exception" // maps variable to parameter Exception exception
			)//WHEN
	public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
		logger.info("Throwing Aspect - {} has thrown exception {}"
				,  joinPoint, exception);//WHAT
	}
	
	@AfterReturning(
			pointcut = "execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))",
			returning = "resultValue" // maps variable to Object resultValue
			)//WHEN
	public void logMethodCallSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
		logger.info("AfterReturning Aspect - {} has returned {}"
				,  joinPoint, resultValue);//WHAT
	}

}
