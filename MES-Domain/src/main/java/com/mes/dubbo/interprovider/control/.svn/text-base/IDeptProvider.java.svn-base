package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.Dept;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
public interface IDeptProvider extends DubboBaseInterface<Dept> {
    /**
     * 删除所有数据
     */
    void deleteAll();

    /**
     * 验证分类下是否有数据
     * @param id
     * @return
     * ledengyun--2017/09/22
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException;

}
