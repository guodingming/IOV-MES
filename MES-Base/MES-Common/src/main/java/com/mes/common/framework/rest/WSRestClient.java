package com.mes.common.framework.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WSRestClient {
	private static final Logger log = LoggerFactory.getLogger(WSRestClient.class);
	
	private static WebTarget webResource;
	
	/**
	 * 获取WebTarget
	 * @param url
	 * @return
	 */
	public static WebTarget getRestWebResource(String url){
		if( webResource == null ){
			try {
				Client client = null;
				//http方式
				client = ClientBuilder.newClient();
				webResource = client.target(url);
			
			} catch (Exception e) {
				log.error("WSRestClient 加载失败！", e);
			}
			
		}
		return webResource;
	}
}
