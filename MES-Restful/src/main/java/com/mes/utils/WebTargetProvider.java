package com.mes.utils;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Created by sticver on 14-12-22.
 */
public class WebTargetProvider {

    private static String URL = "http://[ip]:[port]/[service]/rest/";

    public static WebTarget getWebResource(String url) {
        return ClientBuilder.newClient().target(url);
    }

    public static WebTarget getWebResource(String ip, String port) {
        String url = URL.replace("[ip]", ip).replace("[port]", port).replace("[service]","mes");
        return ClientBuilder.newClient().target(url);
    }


}
