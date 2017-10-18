package com.mes.common.framework.rest;

import com.mes.common.framework.domain.TrackableEntity;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;


/**
 * rest服务基础接口
 */
@Api(value = "RESTful服务基础接口", description = "RESTful服务基础接口")
public interface BaseRestServerInterface<Entity extends TrackableEntity> {


    /**
     * 获取所有数据
     *
     * @return
     */
    @GET
    @Path("/byAll")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "查询所有记录", notes = "查询所有记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getAll();


    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @POST
    @Path("/byPage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据条件分页查询记录", notes = "根据条件分页查询记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject getPage(@ApiParam(value = "查询条件和分页参数", required = true, defaultValue = "", example = "{\"pageSize\": 10, \"pageNum\": 1}") Page page);


    /**
     * 根据条件查询
     *
     * @param params 查询条件
     * @return
     */
    @POST
    @Path("/byCondition")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据条件查询记录", notes = "根据条件查询记录", response = JsonViewObject.class, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject getByWhere(@ApiParam(value = "查询条件", required = true) Map<String, Object> params);


    /**
     * 根据条件查询记录数
     *
     * @param params 查询条件
     * @return
     */
    @POST
    @Path("/countByCondition")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据条件查询记录数", notes = "根据条件查询记录数", response = JsonViewObject.class, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject countByCondition(@ApiParam(value = "查询条件", required = true) Map<String, Object> params);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "根据id查询记录", notes = "根据id查询记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getById(@ApiParam(value = "记录的id", required = true, defaultValue = "", example = "1") @PathParam("id") String id);


    /**
     * 根据id删除
     *
     * @param ids，逗号分隔的对象id
     * @return
     */
    @GET
    @Path("/deleting")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "根据多个id删除记录", notes = "根据多个id删除记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject deleteByIds(@ApiParam(value = "多个记录id，用逗号分隔", required = true, defaultValue = "", example = "1,2") @QueryParam("ids") String ids);


    /**
     * 保存
     *
     * @param entity
     * @return
     */
    @POST
    @Path("/creating")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "新建记录", notes = "新建记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON/*,
            authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "general:save", description = "新建操作")})}*/)
    public JsonViewObject save(@ApiParam(value = "记录的JSON格式字符串", required = true) Entity entity);

    /**
     * 编辑
     *
     * @param entity
     * @return
     */
    @POST
    @Path("/updating")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "更新记录", notes = "更新记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON/*,
            authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "general:update", description = "更新操作")})}*/)
    public JsonViewObject update(@ApiParam(value = "记录的JSON格式字符串", required = true) Entity entity);

}
