package com.diginamic.BestiolesREST.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLoggerAspect {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Before("within(com.diginamic.BestiolesREST.service..*)")
	public void logBeforeMethod(JoinPoint joinPoint) {
		LOG.info("Appel de la méthode "+ joinPoint.getSignature().getName()+" de la "+joinPoint.getTarget().getClass() );
	}
	
	@AfterReturning("within(com.diginamic.BestiolesREST.service..*)")
	public void logAfterReturningMethod(JoinPoint joinPoint) {
		LOG.info("Return de la méthode "+ joinPoint.getSignature().getName()+" de la "+joinPoint.getTarget().getClass() );
	}
	
//	@AfterThrowing(pointcut = "within(com.diginamic.BestiolesREST.service..*)", throwing = "exception")
//	public void logAfterThrowingMethod(JoinPoint joinPoint, Exception exception) {
//		LOG.warn("Exception "+exception.toString()+" levée par la méthode "+ joinPoint.getSignature().getName()+" de la "+joinPoint.getTarget().getClass() );
//	}
	
	@Around("within(com.diginamic.BestiolesREST.service..*)")
	public Object logRuntimeMethod(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object retVal = pjp.proceed();
		long endTime = System.currentTimeMillis();
		LOG.info(pjp.toShortString()+" = "+ (endTime-startTime)+"ms");
		return retVal;
	}

}
