package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.Menu;

import java.util.List;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/10.
 */
public interface IMenuProvider extends DubboBaseInterface<Menu> {
    /**
     * 删除所有记录
     */
    void deleteAll() throws DubboProviderException;

    /**
     * 获取菜单项json格式数据
     * @param params
     * @return
     */
    List<Menu> getMenuJson(Map<String, Object> params) throws DubboProviderException;

    /**
     * 根据角色id查询菜单列表
     * @param roleId
     * @return
     */
    List<Menu> getRoleMenus(String roleId) throws DubboProviderException;

    /**
     * 根据菜单ID更新菜单顺序值
     * @param menus
     * @return
     * @throws DubboProviderException
     */
    boolean updateSort(List<Menu> menus) throws DubboProviderException;
}
