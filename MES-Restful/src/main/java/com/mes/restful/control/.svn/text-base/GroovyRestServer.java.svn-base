package com.mes.restful.control;

import com.mes.common.framework.groovy.GroovyRequest;
import com.mes.common.framework.groovy.GroovyUtil;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.script.ScriptException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
@Api(value = "执行groovy脚本", description = "执行groovy脚本"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "groovy", description = "执行groovy脚本")})}*/)
@Path(RestConstants.RestPathPrefix.GROOVY)
public class GroovyRestServer {
    @Path("evalScript")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "执行一段文本表示的脚本片段，得到返回值", notes = "执行一段文本表示的脚本片段，得到返回值")
    public JsonViewObject evalScript(@ApiParam(value = "groovy脚本调用请求", required = true, defaultValue = "", example = "{\"script\": \"return \\\"hello $name\\\"\", \"params\": {\"name\":\"Jack\"}}") GroovyRequest request) {
        JsonViewObject jsonViewObject = new JsonViewObject();
        try {
            jsonViewObject.successPack(GroovyUtil.evalScript(request.getScript(), request.getParams()).toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return jsonViewObject;
    }

    @Path("runScriptFile")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "执行一个脚本文件，得到返回值", notes = "执行一个脚本文件，得到返回值")
    public JsonViewObject runScriptFile(@ApiParam(value = "groovy脚本调用请求", required = true, defaultValue = "", example = "{\"file\": \"/opt/groovy/test.groovy\", \"params\": {\"name\":\"Jack\"}}") GroovyRequest request) {
        JsonViewObject jsonViewObject = new JsonViewObject();
        try {
            jsonViewObject.successPack(GroovyUtil.runScriptFile(request.getFile(), request.getParams()).toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return jsonViewObject;
    }

    @Path("invokeFnInScript")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "调用脚本片段中的一个函数", notes = "调用脚本片段中的一个函数")
    public JsonViewObject invokeFnInScript(@ApiParam(value = "groovy脚本调用请求", required = true, defaultValue = "", example = "{\"script\": \"def hello(name){\\\"hello $name\\\"}\", \"fn\":\"hello\", \"args\": [\"Jack\"]}") GroovyRequest request) {
        JsonViewObject jsonViewObject = new JsonViewObject();
        try {
            jsonViewObject.successPack(GroovyUtil.invokeFnInScript(request.getScript(), request.getFn(), request.getParams(), request.getArgs()).toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return jsonViewObject;
    }

    @Path("invokeFnInFile")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "调用一个脚本文件中定义的函数", notes = "调用一个脚本文件中定义的函数")
    public JsonViewObject invokeFnInFile(@ApiParam(value = "groovy脚本调用请求", required = true, defaultValue = "", example = "{\"file\": \"/opt/groovy/test.groovy\", \"fn\":\"hello\", \"args\": [\"Jack\"]}") GroovyRequest request) {
        JsonViewObject jsonViewObject = new JsonViewObject();
        try {
            jsonViewObject.successPack(GroovyUtil.invokeFnInFile(request.getFile(), request.getFn(), request.getParams(), request.getArgs()).toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return jsonViewObject;
    }
}
