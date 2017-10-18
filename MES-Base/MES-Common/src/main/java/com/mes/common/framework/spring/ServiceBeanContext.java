package com.mes.common.framework.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceBeanContext {
	
	private static ServiceBeanContext context = null;
	
	private static ApplicationContext ctx=null;

	private ServiceBeanContext(){
		
	}
	
	public static ServiceBeanContext getInstance() {
		if( context == null ){
			context = new ServiceBeanContext();
		}
		return context;
	}
	
	public void loadContext(String path){
		ctx = new ClassPathXmlApplicationContext(path);
	}
	
	public Object getBean(String bean) {
		return ctx.getBean(bean);
	}
}
