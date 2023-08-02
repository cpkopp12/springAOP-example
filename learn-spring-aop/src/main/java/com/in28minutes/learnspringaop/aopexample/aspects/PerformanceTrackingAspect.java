package com.in28minutes.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
//	@Around("com.in28minutes.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
	@Around("com.in28minutes.learnspringaop.aopexample.aspects.CommonPointcutConfig.trackTimeAnnotation()")
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		//start timer
		long startTimeMillis = System.currentTimeMillis();
		
		//run method
		Object returnValue = proceedingJoinPoint.proceed();
		
		//stop timer
		long stopTimeMillis = System.currentTimeMillis();
		
		long executionDuration = stopTimeMillis - startTimeMillis;
		
		logger.info("Around Aspect - {} method executed in {} ms", proceedingJoinPoint, executionDuration);
		
		return returnValue;
	}
	
}
