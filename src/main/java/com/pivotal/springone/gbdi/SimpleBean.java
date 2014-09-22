package com.pivotal.springone.gbdi;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;

/**
 * Just a simple bean that will be instantiated to observe the lifecycle
 * 
 * @author msecrist
 *
 */
public class SimpleBean {
	Logger logger = Logger.getLogger("SimpleBean");
	
	/**
	 * Call to this method is triggered by the existence of the @PostConstruct annotation
	 * Plus the configuration of either <context:annotation-config> or the JavaConfig equivalent
	 * 
	 * This method will be called first (before the call to the initMethod)
	 * 
	 * @see javax.annotation.PostConstruct
	 */
	@PostConstruct
	public void aPostConstructMethod() {
		logger.info("aPostConstructMethod() called");
	}

	/**
	 * This is another initialization method designed to be called by the presentce of the init-method
	 * attribute to the <bean> tag in the Spring XML configuration file.
	 * 
	 * This method should be called after the post construct method above
	 */
	public void anInitMethod() {
		logger.info("anInitMethod() called");
	}

}
