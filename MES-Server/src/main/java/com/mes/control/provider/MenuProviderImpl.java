package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.MenuMapper;
import com.mes.dubbo.interprovider.control.IMenuProvider;
import com.mes.entity.control.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
public class MenuProviderImpl extends BaseProviderImpl<Menu> implements IMenuProvider {

    @Autowired
    @Qualifier("menuMapper")
    private MenuMapper menuMapper;

    @Override
    public MenuMapper getBaseInterfaceMapper() {
        return menuMapper;
    }

    @Override
    public void deleteAll() {
        this.getBaseInterfaceMapper().deleteAll();
    }

    @Override
    public List<Menu> getMenuJson(Map<String, Object> params) throws DubboProviderException {
        return menuMapper.getMenuJson(params);
    }

    @Override
    public List<Menu> getRoleMenus(String roleId) throws DubboProviderException {
        return menuMapper.getUserMenus(roleId);
    }

    @Override
    public boolean updateSort(List<Menu> menus) throws DubboProviderException {
        boolean result = true;
        try {
            if (null != menus && menus.size() > 0) {
                for (Menu menu : menus) {
                    this.menuMapper.update(menu);
                }
            }
        }catch (Exception e){
            result = false;
            log.error("MenuProviderImpl updateSort ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return result;
    }
}
