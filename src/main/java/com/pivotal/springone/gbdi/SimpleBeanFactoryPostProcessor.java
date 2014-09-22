package com.pivotal.springone.gbdi;

import java.util.logging.Logger;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


/**
 * Simple demo class for what the BeanFactoryPostProcessor does
 * 
 * @author msecrist
 * 
 */
public class SimpleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	Logger logger = Logger.getLogger("SimpleBeanFactoryPostProcessor");
	
	private SimpleBean sb;
	
	public void setSimpleBean(SimpleBean sb) {
		logger.info("Setting the simpleBean property");
		this.sb = sb;
	}
	
	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		logger.info("In postProcessBeanFactory");
	}

}
