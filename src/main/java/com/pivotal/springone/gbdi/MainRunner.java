package com.pivotal.springone.gbdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class to bootstrap the Spring ApplicationContext and fetch a list of beans just so we can see
 * what happens during the dependency injection/lifecycle process.
 * 
 * 
 * @author msecrist
 *
 */
public class MainRunner {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("application-config.xml");
		String[] beans = ac.getBeanDefinitionNames();
		System.out.println("Loaded Beans");
		for (String bean : beans) {
			Object beanInstance = ac.getBean(bean);
			System.out.println("Bean: " + bean + " Class: " + beanInstance.getClass().getName());
		}

	}

}
