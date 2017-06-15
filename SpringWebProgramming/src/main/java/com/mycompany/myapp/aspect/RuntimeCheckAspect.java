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
	//PointCut(�ش� Ŭ���� ���� �ۺ����� ������ ��� �޼ҵ带 ����, �Ű����� �� ����
	//annotation�� ���ڿ� ������� annotation �ȿ� ���� �� ���� ������ �޼ҵ带 �ϳ� �����ؼ� �ٸ� ������̼ǿ��� ���
	@Pointcut("execution(public * com.mycompany.myapp.controller.Exam12DBController.*(..))")
	private void runtimeCheckMethod(){}
	
	//Advice
	@Around("runtimeCheckMethod()")
	public Object runtimeCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		//before code
		long startTime = System.nanoTime();
		
		Object result = joinPoint.proceed();	//���� �޼ҵ� ȣ��
		
		//after code
		long endTime = System.nanoTime();
		
		long time = endTime - startTime;
		
		String realMethod = joinPoint.getSignature().toShortString();
		LOGGER.info(realMethod + " ���� �ð�: " + time);
		
		return result;
	}
}
