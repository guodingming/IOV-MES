package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.PdFileType;

import java.util.List;

/**
 * 文件分类管理
*/
public interface IPdFileTypeProvider extends DubboBaseInterface<PdFileType> {

    /**
     * 查询文件类别树
     * @param type
     * @return
     * @throws DubboProviderException
     */
    public List<PdFileType> findByType(String type)throws DubboProviderException;

    /**
     * 分类删除验证
     * @param id
     * @return
     * lednegyun--2017/10/10
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException;
}
