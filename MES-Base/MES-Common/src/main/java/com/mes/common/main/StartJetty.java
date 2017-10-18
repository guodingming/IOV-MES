package com.mes.common.main;

import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.utils.DateUtil;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;


public class StartJetty {
	
	
	private static StartJetty  sj = null;

	
	private StartJetty(){
		
	}
	
	public static StartJetty getInstance(){
		if (sj == null) {
			sj = new StartJetty();
		}
		return sj;
	}
	
	public void startJetty(){

		Server server = new Server(Integer.parseInt(ConfigHelper.getJettyParameter("server.port")));
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath(ConfigHelper.getJettyParameter("server.name"));
        webapp.setResourceBase(ConfigHelper.getJettyParameter("server.resource"));
        webapp.setDescriptor(ConfigHelper.getJettyParameter("server.resource")+"/"+ConfigHelper.getJettyParameter("server.descriptor"));
        webapp.setParentLoaderPriority(true);
        webapp.setClassLoader(Thread.currentThread().getContextClassLoader());
        
        server.setHandler(webapp);

        try {
        	System.out.println("===========================================================");
			System.out.println("["+ DateUtil.getDateTime()+"] "+ConfigHelper.getJettyParameter("server.name")+" is starting......");
			server.start();
			System.out.println("[" + DateUtil.getDateTime() + "] " + ConfigHelper.getJettyParameter("server.name") + " has been started.");
			System.out.println("[" + DateUtil.getDateTime()+ "] Please visit: http://127.0.0.1" + ":"+ ConfigHelper.getJettyParameter("server.port")+ ConfigHelper.getJettyParameter("server.name"));
			System.out.println("["+DateUtil.getDateTime()+"] "+ConfigHelper.getJettyParameter("server.name")+" Start successfully.");
			System.out.println("===========================================================");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}
