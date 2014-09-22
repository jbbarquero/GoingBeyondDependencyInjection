package com.pivotal.springone.gbdi;

import java.util.logging.Logger;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * A simple BeanPostProcessor class is defined to observe the lifecycle process. This should allow us 
 * to see when certain events show up.
 * 
 * @author msecrist
 *
 */
public class SimpleBeanPostProcessor implements BeanPostProcessor {
	private Logger logger = Logger.getLogger("SimpleBeanPostProcessor");
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		logger.info("In postProcessBeforeInitialization for bean: " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		logger.info("In postProcessAfterInitialization for bean: " + beanName);
		return bean;
	}

}
