package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.*;
import com.mes.control.utils.AdDomainUtil;
import com.mes.dubbo.interprovider.control.IPdBomAffiliatedProvider;
import com.mes.dubbo.interprovider.control.IUserProcessProvider;
import com.mes.dubbo.interprovider.control.IUserProvider;
import com.mes.entity.control.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
public class UserProviderImpl extends BaseProviderImpl<User> implements IUserProvider {
    private static Logger logger = LoggerFactory.getLogger(UserProviderImpl.class);

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Autowired
    @Qualifier("menuMapper")
    private MenuMapper menuMapper;

    @Autowired
    @Qualifier("userProcessMapper")
    private UserProcessMapper userProcessMapper;

    @Autowired
    @Qualifier("dpProduceProcessMapper")
    private DpProduceProcessMapper dpProduceProcessMapper;
    @Autowired
    @Qualifier("dpProductInfoLogMapper")
    private DpProductInfoLogMapper dpProductInfoLogMapper;


    @Autowired
    @Qualifier("dpFormMapper")
    private DpFormMapper dpFormMapper;

    @Autowired
    @Qualifier("pdWorkOrderMapper")
    private PdWorkOrderMapper pdWorkOrderMapper;
    @Autowired
    @Qualifier("pdMapper")
    private PdMapper pdMapper;

    @Autowired
    @Qualifier("userProcessProvider")
    private IUserProcessProvider userProcessProvider;

    @Autowired
    @Qualifier("pdBomWorkMapper")
    private PdBomWorkMapper pdBomWorkMapper;

    @Autowired
    @Qualifier("pdBomAffiliatedProvider")
    private IPdBomAffiliatedProvider pdBomAffiliatedProvider;

    @Override
    public UserMapper getBaseInterfaceMapper() {
        return userMapper;
    }

    @Override
    public Map<String, Object> login(UserLogin userLogin) {
        boolean adAuth = true;
        // 使用AD域进行验证
        if ("true".equalsIgnoreCase(ConfigHelper.getValue("ldap.user.auth"))) {
            adAuth = AdDomainUtil.auth(userLogin.getUsername(), userLogin.getPassword());
        }

        userLogin.setAdAuth(adAuth);
        // 根据adAuth执行sql验证的条件不同
//        logger.info("User login request: " + JSON.toJSONString(userLogin));
        User u = this.getBaseInterfaceMapper().getLoginInfo(userLogin);
        if (u != null) {
            Map<String, Object> ret = Maps.newHashMap();
            List<Menu> menus = menuMapper.getUserMenus(u.getRoleId());
            ret.put("userInfo", u);
            ret.put("menu", menus);
            return ret;
        } else {
            return null;
        }

    }

    @Override
    public Map<String, Object> validate(UserLogin userLogin) throws DubboProviderException {
        return this.login(userLogin);
    }

    @Override
    public JsonViewObject switchStation(UserProcess userProcess) throws DubboProviderException {
        return this.auth(userProcess);
    }

    @Override
    public JsonViewObject auth(UserProcess userProcess) throws DubboProviderException {
        JsonViewObject jsonViewObject = new JsonViewObject();
        try {
            // 生产工序id
            String produceProcessId = userProcess.getProcessId();
            DpProduceProcess dpProduceProcess = dpProduceProcessMapper.findById(produceProcessId);
            PdWorkOrder workOrder = this.pdWorkOrderMapper.findById(userProcess.getWorkOrderId());
            UserLogin userLogin = new UserLogin();
            userLogin.setUsername(userProcess.getUsername());
            userLogin.setPassword(userProcess.getPassword());
            User u = this.getBaseInterfaceMapper().getLoginInfo(userLogin);
            if (u != null) {
                Map<String, Object> map = Maps.newHashMap();
                map.put("userId", u.getId());
                map.put("processId", dpProduceProcess.getProcessId());
                map.put("processStatus", "1");
                UserProcess userProcesse = userProcessMapper.findAuthProcess(map);
                if (userProcesse != null) {
                    DpForm form = dpFormMapper.findById(dpProduceProcess.getFormId());
                    if (form != null) {
                        // 验证成功返回当前工序对应的表单和用户信息
                        Map<String, Object> result = Maps.newHashMap();
                        result.put("userInfo", u);
                        result.put("form", form);
                        result.put("produceProcess", dpProduceProcess);
                        result.put("workOrder", workOrder);
                        Map<String, Object> query = Maps.newHashMap();
                        query.put("userId", u.getId());
                        query.put("projectId", workOrder.getProjectId());
                        query.put("processStatus", "1");
                        List<UserProcess> userProcessList = this.userProcessMapper.findByUserAndProject(query);
                        result.put("userProcessList", userProcessList);
                        jsonViewObject.successPack(result);
                        this.userProcessProvider.updateAuthTime(userProcess);
                    } else {
                        jsonViewObject.failPack(null, "指定的生产工序未关联表单");
                    }
                } else {
                    jsonViewObject.failPack(null, "登录的用户不具有执行此工序的能力！");
                }
            } else {
                jsonViewObject.failPack(null, "用户登录失败！");
            }
        } catch (Exception e) {
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonViewObject;
    }

    @Override
    public JsonViewObject authDevice(UserProcess userProcess) {
        JsonViewObject jsonViewObject = new JsonViewObject();
        // 生产工序id
        String produceProcessId = userProcess.getProcessId();
        DpProduceProcess dpProduceProcess = dpProduceProcessMapper.findById(produceProcessId);
        PdWorkOrder workOrder = this.pdWorkOrderMapper.findById(userProcess.getWorkOrderId());

        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(userProcess.getUsername());
        userLogin.setPassword(userProcess.getPassword());
        User u = this.getBaseInterfaceMapper().getLoginInfo(userLogin);
        if (u != null) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("userId", u.getId());
            map.put("processId", dpProduceProcess.getProcessId());
            map.put("processStatus", "1");
            List<UserProcess> userProcesses = userProcessMapper.findByMap(map);
            if (userProcesses != null && !userProcesses.isEmpty()) {
                // 验证成功返回当前工序对应的表单和用户信息
                Map<String, Object> result = Maps.newHashMap();
                result.put("userInfo", u);
                result.put("produceProcess", dpProduceProcess);
                result.put("workOrder", workOrder);
                Map<String, Object> query = Maps.newHashMap();
                query.put("userId", u.getId());
                query.put("projectId", workOrder.getProjectId());
                query.put("processStatus", "1");
                List<UserProcess> userProcessList = this.userProcessMapper.findByUserAndProject(query);
                result.put("userProcessList", userProcessList);
                jsonViewObject.successPack(result);
            } else {
                jsonViewObject.failPack(null, "登录的用户不具有执行此工序的能力！");
            }
        } else {
            jsonViewObject.failPack(null, "用户登录失败！");
        }

        return jsonViewObject;
    }

    @Override
    public JsonViewObject stationValidate(UserProcess userProcess) throws DubboProviderException {
        return this.auth(userProcess);
    }


    /**
     * 校验用户名面
     *
     * @param user
     * @return 若果正确返回用户对象
     */
    private User validateUser(User user) {
        Map<String, Object> query = Maps.newHashMap();
        query.put("username", user.getUsername());
        query.put("password", user.getPassword());
        User userInfo = this.userMapper.validateUserInfo(query);
        return userInfo;
    }

    @Override
    public void deleteAll() {
        userMapper.deleteAll();
    }

    @Override
    public void deleteAllUserDept() {
        userMapper.deleteAllUserDept();
    }

    @Override
    public String save(User user) throws DubboProviderException {
        String id = super.save(user);
        saveDeptAuth(id, user.getDeptId());
        return id;
    }

    private void saveDeptAuth(String userId, String deptId) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", IDGenerator.getID());
        map.put("userId", userId);
        map.put("deptId", deptId);
        userMapper.saveDeptAuth(map);
    }

    @Override
    public boolean deleteById(String id) throws DubboProviderException {
        //deleteDeptAuth(id);
        deleteUserGroupAuth(id);
        return super.deleteById(id);
    }

    private void deleteUserGroupAuth(String id) {
        userMapper.deleteUserGroupAuth(id);
    }

    private void deleteDeptAuth(String id) {
        userMapper.deleteDeptAuth(id);
    }

    /**
     * 批量添加指定用户组下的用户
     *
     * @param groupId
     * @param userIds
     */
    @Override
    public void saveGroupAuthBatch(String groupId, List<String> userIds) {
        if (userIds != null && !userIds.isEmpty()) {
            userIds.stream().forEach(userId -> {
                Map<String, Object> map = Maps.newHashMap();
                map.put("id", IDGenerator.getID());
                map.put("userGroupId", groupId);
                map.put("userId", userId);
                userMapper.saveGroupAuth(map);

            });
        }
    }

    /**
     * 批量删除指定用户组下的用户
     *
     * @param groupId
     * @param userIds
     */
    @Override
    public void deleteByGroupIdAndUserIds(String groupId, List<String> userIds) {
        if (userIds != null && !userIds.isEmpty()) {
            userIds.stream().forEach(userId -> {
                Map<String, Object> map = Maps.newHashMap();
                map.put("groupId", groupId);
                map.put("userId", userId);
                userMapper.deleteByGroupIdAndUserIds(map);
            });

        }


    }

    /**
     * 查询指定部门下不属于指定用户组的所有用户
     *
     * @param user
     * @return
     */
    @Override
    public List<User> getAssignableUsers(User user) {
        return this.getBaseInterfaceMapper().getAssignableUsers(user);
    }

    public boolean updateDelete(String id, String isDelete) throws DubboProviderException {
        boolean flag = false;
        User user = new User();
        user.setId(id);
        user.setIsDelete(isDelete);
        if (user != null) {
            userMapper.update(user);
            flag = true;
        }
        return flag;
    }

    /**
     * 根据部门分页查询用户列表
     *
     * @param page
     * @return
     * @throws DubboProviderException
     */
    @Override
    public Page getPageByDeptId(Page page) throws DubboProviderException {
        Map<String, Object> params = Maps.newHashMap();
        if (page != null && page.getCondition() != null) {
            if (Map.class.isInstance(page.getCondition())) {
                params = (Map<String, Object>) page.getCondition();
            }
        }

        try {
            page.setTotal(this.getBaseInterfaceMapper().getCountByDeptId(params));
            params.put("startRowNum", page.getStartRowNum());
            params.put("pageSize", page.getPageSize());
            page.setRows(this.getBaseInterfaceMapper().findPageByDeptId(params));
        } catch (Exception e) {
            log.error("UserProviderImpl getPageByDeptId ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return page;
    }

    /**
     * 根据用户组分页查询用户列表
     *
     * @param page
     * @return
     * @throws DubboProviderException
     */
    @Override
    public Page getPageByUserGroupId(Page page) throws DubboProviderException {
        Map<String, Object> params = Maps.newHashMap();
        if (page != null && page.getCondition() != null) {
            if (Map.class.isInstance(page.getCondition())) {
                params = (Map<String, Object>) page.getCondition();
            }
        }

        try {
            page.setTotal(this.getBaseInterfaceMapper().getCountByUserGroupId(params));
            params.put("startRowNum", page.getStartRowNum());
            params.put("pageSize", page.getPageSize());
            page.setRows(this.getBaseInterfaceMapper().findPageByUserGroupId(params));
        } catch (Exception e) {
            log.error("UserProviderImpl getPageByUserGroupId ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return page;
    }

    /**
     * 获取工单信息
     *
     * @param workOrderId
     * @param produceProcessId
     * @return ledengyun--2017/09/06
     * @throws DubboProviderException
     */
    public Map<String, Object> getOrderInfo(String workOrderId, String produceProcessId, String processName) throws DubboProviderException {
        String workOrderNum = null;
        Long workOrderTotal = null;
        String pdId = null;
        Map<String, Object> map = Maps.newHashMap();
        String bomProduceId = "";
        //获取工单号，工单数量
        PdWorkOrder pdWorkOrder = pdWorkOrderMapper.findById(workOrderId);
        if (pdWorkOrder != null) {
            workOrderNum = pdWorkOrder.getWorkOrderNum();
            workOrderTotal = pdWorkOrder.getWorkOrderTotal();
            pdId = pdWorkOrder.getPdId();
            setMapValue(map, "workOrderNum", workOrderNum);
            setMapValue(map, "workOrderTotal", String.valueOf(workOrderTotal));

            PdBomWork pdBomWork = pdBomWorkMapper.findById(pdWorkOrder.getBomWorkId());
            if (pdBomWork != null) {
                bomProduceId = pdBomWork.getBomProduceId();
            }
        }
        String pdName = "";
        String pdCode = "";
        //获取产品名称，产品Code
        Pd pd = pdMapper.findById(pdId);
        if (pd != null) {
            pdName = pd.getName();
            pdCode = pd.getCode();
            setMapValue(map, "pdName", pdName);
            setMapValue(map, "pdCode", pdCode);
        }

        // 产品零件号，为产品单项配置
        String clientNo = "pl_client_number";
        List<PdBomAffiliated> partNos = pdBomAffiliatedProvider.findAffiliates(pdId, clientNo, bomProduceId);
        if (partNos != null && !partNos.isEmpty()) {
            setMapValue(map, "partNo", partNos.get(0).getValue());
        }

        // 软件版本，为产品单项配置
        String softwareVersion = "software_version";
        List<PdBomAffiliated> softwareVersions = pdBomAffiliatedProvider.findAffiliates(pdId, softwareVersion, bomProduceId);
        if (softwareVersions != null && !softwareVersions.isEmpty()) {
            setMapValue(map, "softwareVersion", softwareVersions.get(0).getValue());
        }

        // 硬件版本，为产品单项配置
        String hardwareVersion = "hardware_version";
        List<PdBomAffiliated> hardwareVersions = pdBomAffiliatedProvider.findAffiliates(pdId, hardwareVersion, bomProduceId);
        if (hardwareVersions != null && !hardwareVersions.isEmpty()) {
            setMapValue(map, "hardwareVersion", hardwareVersions.get(0).getValue());
        }

        Map ma = new HashMap();
        ma.put("workOrderId", workOrderId);
        ma.put("produceProcessId", produceProcessId);
        ma.put("isSuccess", "1");
        int processSucess = dpProductInfoLogMapper.getCount(ma);
        map.put("processSuccess", String.valueOf(processSucess));
        ma.put("isSuccess", "0");
        int processFali = dpProductInfoLogMapper.getCount(ma);
        map.put("processFail", String.valueOf(processFali));
        setMapValue(map, "processName", processName);

        return map;
    }

    /**
     * 设置map属性
     *
     * @param result
     * @param key
     * @param value
     */
    private void setMapValue(Map<String, Object> result, String key, Object value) {
        if (null != value) {
            result.put(key, value);
        } else {
            result.put(key, "");
        }
    }
}
