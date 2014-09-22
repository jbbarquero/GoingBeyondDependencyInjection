package com.pivotal.springone.gbdi;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

/**
 * An example of using a custom BeanPostProcessor to do something interesting like look for all beans that
 * are of type ExceptionResolver and attempt to change the order to a pre-configured order as defined
 * by the properties field.
 * 
 * @author msecrist
 *
 */
public class ExceptionResolverOrderPostProcessor implements BeanPostProcessor {
	private Properties exceptionResolvers;	

	public Properties getExceptionResolvers() {
		return exceptionResolvers;
	}

	public void setExceptionResolvers(Properties exceptionResolvers) {
		this.exceptionResolvers = exceptionResolvers;
	}

	/**
	 * We'll do this before any other initialization. Looks for beans of type AbstractExceptionResolver
	 * and then attemps to set the order property to the configured one. This assumes the BPP has been
	 * configured with a list of ExceptionResolvers and their desired order.
	 * 
	 * @param bean The current bean instance to post process.
	 * @param beanName The name this bean is currently registered as.
	 *   
	 * @see org.springframework.web.servlet.handler.AbsractExceptionResolver
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		
		if (bean instanceof AbstractHandlerExceptionResolver) {
			System.out.println("Processing an ExceptionResolver for bean: " + beanName);
				if (exceptionResolvers.containsKey(bean.getClass().getSimpleName())) {
					Integer order = new Integer( (String) exceptionResolvers.get(bean.getClass().getSimpleName()));
					System.out.println("Setting order to: " + order);
					((AbstractHandlerExceptionResolver) bean).setOrder((order) );
				}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

}
