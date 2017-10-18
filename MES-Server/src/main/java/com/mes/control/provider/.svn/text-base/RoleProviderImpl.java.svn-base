package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.RoleMapper;
import com.mes.dubbo.interprovider.control.IRoleProvider;
import com.mes.entity.control.Menu;
import com.mes.entity.control.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
public class RoleProviderImpl extends BaseProviderImpl<Role> implements IRoleProvider {

    @Autowired
    @Qualifier("roleMapper")
    private RoleMapper roleMapper;

    @Override
    public RoleMapper getBaseInterfaceMapper() {
        return roleMapper;
    }

    /**
     * 新增角色菜单权限
     * @param roleId
     * @param menuIds
     */
    @Override
    public void saveMenuAuth(String roleId, List<String> menuIds) {
        roleMapper.deleteMenuAuth(roleId);
        if (menuIds != null && !menuIds.isEmpty()) {
            menuIds.stream().forEach(menuId -> {
                Map<String, Object> map = Maps.newHashMap();
                map.put("id", IDGenerator.getID());
                map.put("roleId", roleId);
                map.put("menuId", menuId);
                roleMapper.saveMenuAuth(map);
            });
        }
    }

    /**
     * 查询角色菜单权限
     * @param roleId
     * @return
     */
    @Override
    public List<Menu> getMenuAuth(String roleId) {
        return roleMapper.getMenuAuth(roleId);
    }

    /**
     * 验证分类下是否有数据
     * @param id
     * @return
     * ledengyun--2017/09/22
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException{

        int usage;
        boolean flag = true;
        usage = roleMapper.countUsage(id);
        if(usage>0){
            flag = false;
        }
        return flag;
    }
}
