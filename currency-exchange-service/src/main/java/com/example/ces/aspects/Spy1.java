package com.example.ces.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Spy1 {

	@Pointcut("execution(* com.example.ces.controller.CircuitBreakerController.*(..))")
	public void circuitBreakerControllerPC() {

	}

	@Before("circuitBreakerControllerPC()")
	public void report(JoinPoint theJoinPoint) {
		System.out.println("     VIA ASPECT      " + theJoinPoint.getSignature().toString() + "           ");
	}

	@AfterThrowing(pointcut = "circuitBreakerControllerPC()", throwing = "e")
	public void reportError(JoinPoint theJoinPoint, Exception e) {
		System.out.println("     VIA ASPECT      " + theJoinPoint.getSignature().toString() + "   exception:      "
				+ e.getMessage());
	}

}
