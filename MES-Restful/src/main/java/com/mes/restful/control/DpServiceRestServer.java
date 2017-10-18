package com.mes.restful.control;

import com.alibaba.fastjson.JSON;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.IDGenerator;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpServiceProvider;
import com.mes.entity.control.DpService;
import com.mes.entity.control.DpServiceInvocation;
import com.mes.entity.control.DpServiceRequest;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 开发平台-服务管理
 */
@Api(value = "开发平台-服务管理", description = "开发平台-服务管理")
@Path(RestConstants.RestPathPrefix.DPSERVICE)
public class DpServiceRestServer extends BaseRestServerInterfaceImpl<DpService> {
    private static ExecutorService pool = Executors.newFixedThreadPool(Integer.parseInt(ConfigHelper.getValue("service.monitor.threadpool.size")));

    @Override
    public IDpServiceProvider getDubboBaseInterface() {
        return ControlConsumer.getDpServiceProvider();
    }

    /**
     * 服务接口调用
     *
     * @param methodName 接口方法名称
     * @param request
     * @return
     */
    @POST
    @Path("invoke/{methodName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "服务接口调用", notes = "服务接口调用", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject invoke(@PathParam("methodName") String methodName, @ApiParam(value = "服务接口调用请求参数", required = true) DpServiceRequest request) {
        long start = System.currentTimeMillis();
        String status = "success";
        Object result = null;
        try {
            result = this.getDubboBaseInterface().saveInvocation(request);
            // 如果接口返回JsonViewObject，则不再包装一层
            if (result != null && JsonViewObject.class.isInstance(result)) {
                jsonView = (JsonViewObject) result;
            } else {
                this.addOperationLog("服务接口调用成功！", "", true);
                jsonView.successPack(result, "服务接口调用成功！");
            }
        } catch (DubboProviderException e) {
            status = "fail";
            jsonView.failPack(e);
            this.addOperationLog("服务接口调用失败", "", false);
            log.error("DpServiceRestServer invoke is error", e);
        }
        final String s = status;
        long time = System.currentTimeMillis() - start;
        String finalResult = JSON.toJSONString(result);
        pool.submit(new Thread() {
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                DpServiceInvocation invocation = new DpServiceInvocation();
                invocation.setCode(request.getCode());
                invocation.setParams(JSON.toJSONString(request));
                invocation.setResult(finalResult);
                invocation.setPath("invoke/" + methodName);
                invocation.setStartTime(sdf.format(new Date(start)));
                invocation.setTookTime(time + "");
                invocation.setStatus(s);

                try {
                    ControlConsumer.getDpServiceProvider().logInvocation(invocation);
                } catch (DubboProviderException e) {
                    e.printStackTrace();
                }
            }
        });
        return jsonView;
    }

    /**
     * 生成服务编码
     *
     * @return
     */
    @GET
    @Path("generateCode")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "生成服务编码", notes = "生成服务编码", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject generateCode() {
        jsonView.successPack(IDGenerator.getID(), "生成服务编码成功！");
        return jsonView;
    }
}
