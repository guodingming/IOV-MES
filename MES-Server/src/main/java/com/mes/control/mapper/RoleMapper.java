package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.Menu;
import com.mes.entity.control.Role;

import java.util.List;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
public interface RoleMapper extends BaseInterfaceMapper<Role> {
    /**
     * 新增角色菜单权限
     * @param map
     */
    void saveMenuAuth(Map<String, Object> map);

    /**
     * 查询角色菜单权限
     * @param roleId
     * @return
     */

    List<Menu> getMenuAuth(String roleId);

    /**
     * 删除菜单权限
     * @param roleId
     */

    void deleteMenuAuth(String roleId);

    int countUsage(String roleId);
}
