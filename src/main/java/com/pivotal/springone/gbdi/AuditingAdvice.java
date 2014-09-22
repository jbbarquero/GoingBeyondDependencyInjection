package com.pivotal.springone.gbdi;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Simple auditing advice example. This bean will be discovered via component scanning
 * 
 * @author msecrist
 *
 */
@Aspect
@Component
public class AuditingAdvice {
	private Logger logger = Logger.getLogger(getClass());

	/**
	 * Matches on any method that is annotated with @Auditable
	 * 
	 * @param jp Context information on the current joinpoint
	 * 
	 * @see Auditable
	 */
	@Before("execution(@com.pivotal.springone.gbdi.Auditable * *(..))")
	public void doAudit(JoinPoint jp) {
		Object target = jp.getTarget();
		logger.info("Audit on " + target.getClass().getSimpleName() + " for method " + jp.getSignature().getName());
	}
}
