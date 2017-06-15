package com.mycompany.myapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RuntimeCheckAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(RuntimeCheckAspect.class);
	//PointCut(해당 클래스 내에 퍼블릭으로 생성된 모든 메소드를 지정, 매개변수 상괍 없음
	//annotation은 문자열 방식으로 annotation 안에 넣을 수 없기 때문에 메소드를 하나 선언해서 다른 어노테이션에서 사용
	@Pointcut("execution(public * com.mycompany.myapp.controller.Exam12DBController.*(..))")
	private void runtimeCheckMethod(){}
	
	//Advice
	@Around("runtimeCheckMethod()")
	public Object runtimeCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		//before code
		long startTime = System.nanoTime();
		
		Object result = joinPoint.proceed();	//실제 메소드 호출
		
		//after code
		long endTime = System.nanoTime();
		
		long time = endTime - startTime;
		
		String realMethod = joinPoint.getSignature().toShortString();
		LOGGER.info(realMethod + " 실행 시간: " + time);
		
		return result;
	}
}
