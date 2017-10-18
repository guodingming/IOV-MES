package com.mes.common.main;

import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.utils.DateUtil;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;


public class DeveloperStartJetty {


	private static DeveloperStartJetty sj = null;

	private DeveloperStartJetty(){
		
	}
	
	public static DeveloperStartJetty getInstance(){
		if (sj == null) {
			sj = new DeveloperStartJetty();
		}
		return sj;
	}
	
	public void startJetty(){
		String rootPath=DeveloperStartJetty.class.getResource("/").getFile().toString();
		rootPath = rootPath.replace("target/classes/","src/main/webapp/");
		Server server = new Server(Integer.parseInt(ConfigHelper.getJettyParameter("server.port")));
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath(ConfigHelper.getJettyParameter("server.name"));
		webapp.setResourceBase(rootPath);
		webapp.setDescriptor(rootPath+"/"+ConfigHelper.getJettyParameter("server.descriptor"));
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
