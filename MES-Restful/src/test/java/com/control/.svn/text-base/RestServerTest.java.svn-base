package com.control;

import com.BaseTest;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.mes.common.framework.rest.view.Page;
import com.mes.utils.RestConstants;
import com.mes.utils.WebTargetProvider;
import org.junit.Test;


import javax.ws.rs.client.Entity;
import java.util.Map;

/**
 * Created by Administrator on 2017-05-11 10:23:47
 */
public class RestServerTest extends BaseTest {
    @Test
    public void testFindPage() {
        Page page = new Page();
        page.setPageSize(10);
        page.setStartRowNum(0);
        page.setCondition("");
        String jsonStr = JSON.toJSONString(page);
        String result = WebTargetProvider.getWebResource(ip, port)
                .path(RestConstants.RestPathPrefix.USER + "clusterNodeRestServer")
                .path("byPage")
                .request()
                .post(Entity.entity(jsonStr, "application/json"), String.class);
        System.out.println("getPage result:" + result);
    }

    @Test
    public void testGetAll() {
        String result = WebTargetProvider.getWebResource(ip, port)
                .path(RestConstants.RestPathPrefix.USER + "clusterNodeRestServer")
                .path("getAll")
                .request()
                .get(String.class);
        System.out.println("getPage result:" + result);
    }

    @Test
    public void testSave() {
        Map value = Maps.newHashMap();
        value.put("", "");

        String jsonStr = JSON.toJSONString(value);
        String result = WebTargetProvider.getWebResource(ip, port)
                .path(RestConstants.RestPathPrefix.USER + "clusterNodeRestServer")
                .path("save")
                .request()
                .post(Entity.entity(jsonStr, "application/json"), String.class);
        System.out.println("save result:" + result);
    }

    @Test
    public void testUpdate() {
        Map value = Maps.newHashMap();
        value.put("id", "");
        String jsonStr = JSON.toJSONString(value);
        String result = WebTargetProvider.getWebResource(ip, port)
                .path(RestConstants.RestPathPrefix.USER + "clusterNodeRestServer")
                .path("update")
                .request()
                .post(Entity.entity(jsonStr, "application/json"), String.class);
        System.out.println("update result:" + result);
    }

    @Test
    public void testDelete() {

        String result = WebTargetProvider.getWebResource(ip, port)
                .path(RestConstants.RestPathPrefix.USER + "clusterNodeRestServer")
                .path("deleteById")
                .queryParam("id", "")
                .request()
                .get(String.class);
        System.out.println("delete result:" + result);
    }


    @Test
    public void testStart() {
        String result = WebTargetProvider.getWebResource(ip, port)
                .path(RestConstants.RestPathPrefix.USER + "clusterNodeRestServer")
                .path("start")
                .request()
                .get(String.class);
        System.out.println("getPage result:" + result);
    }
}
