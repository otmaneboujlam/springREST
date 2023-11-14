package com.diginamic.BestiolesREST.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLoggerAspect {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Before("within(com.diginamic.BestiolesREST.controller..*)")
	public void logBeforeMethod(JoinPoint joinPoint) {
		LOG.info("Appel de la méthode "+ joinPoint.getSignature().getName()+" de la "+joinPoint.getTarget().getClass() );
	}
	
	@AfterReturning("within(com.diginamic.BestiolesREST.controller..*)")
	public void logAfterReturningMethod(JoinPoint joinPoint) {
		LOG.info("Return de la méthode "+ joinPoint.getSignature().getName()+" de la "+joinPoint.getTarget().getClass() );
	}
	
//	@AfterThrowing(pointcut = "within(com.diginamic.BestiolesREST.controller..*)", throwing = "exception")
//	public void logAfterThrowingMethod(JoinPoint joinPoint, Exception exception) {
//		LOG.warn("Exception "+exception.toString()+" levée par la méthode "+ joinPoint.getSignature().getName()+" de la "+joinPoint.getTarget().getClass() );
//	}

}
