/*package org.kosta.momsbay.model.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ReportAspact {
	
	@Around("execution(public * org.kosta.momsbay.model.*Service.find*List*(..))")
	public Object saveReport(ProceedingJoinPoint point) throws Throwable {
		Object retValue = null;
		retValue = point.proceed();
		@SuppressWarnings("rawtypes")
		List list = (List) retValue;
		Object params[] = point.getArgs();
		String keyword = (String) params[0];
		if(list.isEmpty()==false) {
			
		}
		return retValue;
	}
}
*/