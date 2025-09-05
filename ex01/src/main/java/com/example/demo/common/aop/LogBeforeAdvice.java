package com.example.demo.common.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogBeforeAdvice {

	// 포인트컷
	 @Pointcut("execution(* com.example..*Impl.*(..))") // 메서드이름이 impl로 시작하는
	   public void  allpointcut() {}
	
	 @Before("allpointcut()") // before : 서비스 실행 전에, after : 서비스 실행 후에
	public void print() {
		System.out.println("[before 로그실행");
	}
}
