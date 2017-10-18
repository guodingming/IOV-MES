package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IUserProcessProvider;
import com.mes.entity.control.UserProcess;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

/**
 * 用户管理-人员技能
*/
@Api(value = "用户管理-人员技能", description = "用户管理-人员技能")
@Path(RestConstants.RestPathPrefix.USERPROCESS)
public class UserProcessRestServer extends BaseRestServerInterfaceImpl<UserProcess> {
	@Override
	public IUserProcessProvider getDubboBaseInterface() {
		return ControlConsumer.getUserProcessProvider();
	}


	/**
	 * 获取指定用户的
	 * @param userProcess
	 * @return
	 */
	@POST
	@Path("getStationProcess")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "获取工作站工序列表", notes = "获取工作站工序列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getStationProcess(UserProcess userProcess) {
		try {
			if (null != userProcess) {
				List<UserProcess> userProcesses = this.getDubboBaseInterface().findProcessByUserAndProject(userProcess);
				this.addOperationLog("获取工作站工序列表成功", "", true);
				jsonView.successPack(userProcesses, "获取工作站工序列表成功!");
			}
		} catch (Exception e) {
			jsonView.failPack(e);
			this.addOperationLog("获取工作站工序列表失败", "", false);
			log.error("UserProcessRestServer getStationProcess is error", e);
		}
		return jsonView;
	}

	/**
	 * 切换状态
	 *
	 * @param processStatus
	 * @param id
	 * @return
	 */
	@GET
	@Path("/switchStatus")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "切换状态", notes = "切换状态", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject switchStatus(@ApiParam(value = "工序状态", required = true) @QueryParam("processStatus") String processStatus, @ApiParam(value = "记录ID", required = true) @QueryParam("id") String id) {
		try {
			if (StringUtils.isNotBlank(processStatus) && StringUtils.isNotBlank(id)) {
				boolean flag = this.getDubboBaseInterface().updateStatus(processStatus, id);
				if (flag) {
					jsonView.successPack(true, "授权成功!");
				} else {
					jsonView.failPack(false, "授权失败!");
				}
			}
		} catch (Exception e) {
			jsonView.failPack(false, "切换状态失败");
			this.addOperationLog("切换状态失败", "", false);
			log.error("UserProcessRestServer switchStatus is error", e);
		}
		return jsonView;
	}

    /**
     * 配置用户业务
     *
     * @param userProcess
     * @return
     */
    @POST
    @Path("configProcess")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "配置用户业务", notes = "配置用户业务", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject configProcess(UserProcess userProcess) {
        try {
            if (null != userProcess) {
                boolean flag = this.getDubboBaseInterface().configProcess(userProcess);
                if (flag) {
                    this.addOperationLog("配置用户业务成功", "", true);
                    jsonView.successPack(flag, "配置用户业务成功!");
                } else {
                    this.addOperationLog("配置用户业务失败", "", false);
                    jsonView.failPack(flag, "配置用户业务失败!");
                }
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("获取工作站工序列表失败", "", false);
            log.error("UserProcessRestServer configProcess is error", e);
        }
        return jsonView;
    }

	/**
	 * 用户管理，业务配置批量保存
	 * @param entity
	 * @return
	 * ledengyun--2017/10/09
	 */
	@POST
	@Path("/creating")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "新建记录", notes = "新建记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public JsonViewObject save(@ApiParam(value = "记录的JSON格式字符串", required = true) UserProcess entity){
    	String [] processId = entity.getProcessId().split(",");
    	for (int i=0;i<processId.length;i++){
    		UserProcess userProcess = new UserProcess();
    		userProcess.setProcessId(processId[i]);
    		userProcess.setId(IDGenerator.getID());
    		userProcess.setProcessStatus(entity.getProcessStatus());
    		userProcess.setUserId(entity.getUserId());
    		userProcess.setCreateDate(new Date());
			try {
				this.getDubboBaseInterface().save(userProcess);
				jsonView.successPack(true, "新建记录成功!");
				this.addOperationLog("新建记录成功", "", true);
			} catch (DubboProviderException e) {
				jsonView.failPack(false, "新建记录失败!");
				this.addOperationLog("新建记录失败", "", false);
			}


		}
		return jsonView;

	}

}
