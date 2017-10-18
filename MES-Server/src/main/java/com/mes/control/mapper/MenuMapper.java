package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.Menu;

import java.util.List;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/10.
 */
public interface MenuMapper extends BaseInterfaceMapper<Menu> {
    /**
     * 删除所有菜单项
     */
    void deleteAll();

    /**
     * 根据条件查询菜单，并以层次结构json格式数据返回
     * @param params
     * @return
     */
    List<Menu> getMenuJson(Map<String, Object> params);

    /**
     * 根据角色id获取用户菜单列表
     * @param roleId
     * @return
     */
    List<Menu> getUserMenus(String roleId);
}
