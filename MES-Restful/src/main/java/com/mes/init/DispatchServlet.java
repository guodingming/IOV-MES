package com.mes.init;

import com.mes.common.framework.Constants;
import com.mes.common.framework.spring.ServiceBeanContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 用于初始化webSocket和初始化Kafka监听器的Servlet
 */
public class DispatchServlet extends HttpServlet{

	public static final Logger log = LoggerFactory.getLogger(DispatchServlet.class);
	private static final long serialVersionUID = -2871793876774691057L;

	@Override
	public void init(ServletConfig config) throws ServletException {
        InitReve initReve = new InitReve();
		try {
			ServiceBeanContext.getInstance().loadContext(Constants.Env.BASE_HOME+"applicationContext.xml");
			initReve.init();
		} catch (Exception e) {
			log.error("启动初始化applicationContext.xml失败",e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String className=req.getParameter("className");
		String methodName=req.getParameter("methodName");
		
		try {
			Object obj=ServiceBeanContext.getInstance().getBean(className);
			Method invokeMethod=obj.getClass().getMethod(methodName,
					HttpServletRequest.class,HttpServletResponse.class);
			
			if(invokeMethod!=null){
				resp.setCharacterEncoding("UTF-8");
				invokeMethod.invoke(obj,req,resp);
			} else {
			   throw new Exception("the invokeMethod is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
