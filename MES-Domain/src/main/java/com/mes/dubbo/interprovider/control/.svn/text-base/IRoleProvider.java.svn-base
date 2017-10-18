package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.Menu;
import com.mes.entity.control.Role;

import java.util.List;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
public interface IRoleProvider extends DubboBaseInterface<Role> {
    /**
     * 新增角色菜单权限
     * @param roleId
     * @param menuIds
     */
    void saveMenuAuth(String roleId,List<String> menuIds);

    /**
     * 查询角色菜单权限
     * @param roleId
     * @return
     */
    List<Menu> getMenuAuth(String roleId);

    /**
     * 验证分类下是否有数据
     * @param id
     * @return
     * ledengyun--2017/09/22
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException;
}
