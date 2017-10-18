package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.impl.ExpandTableUtil;
import com.mes.control.mapper.ExpandTableConfigMapper;
import com.mes.control.mapper.TableMapper;
import com.mes.control.utils.EntityTableUtil;
import com.mes.dubbo.interprovider.control.ITableProvider;
import com.mes.entity.control.ExpandTableConfig;
import com.mes.entity.control.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/6.
 */
public class TableProviderImpl extends BaseProviderImpl<Table> implements ITableProvider {
    @Autowired
    @Qualifier("tableMapper")
    private TableMapper tableMapper;
    @Autowired
    @Qualifier("expandTableConfigMapper")
    private ExpandTableConfigMapper expandTableConfigMapper;

    @Override
    public TableMapper getBaseInterfaceMapper() {
        return tableMapper;
    }


    /**
     * 验证主表是否可以删除--有扩展表则不允许删除。
     * @param id
     * @return
     * @throws DubboProviderException
     */
    @Override
    public boolean deleteById(String id) throws DubboProviderException {
        boolean flag = false;
        ExpandTableConfig expandTableConfig = expandTableConfigMapper.findByTableId(id);
        if(expandTableConfig !=null){
            flag = false;
        }else {
            tableMapper.deleteById(id);
            flag = true;
        }
        return flag;
    }

    public List findData(String id) throws DubboProviderException{
        Table table = tableMapper.findById(id);
        ExpandTableConfig expandTableConfig = expandTableConfigMapper.findByTableId(id);
        String tableName_expand = expandTableConfig.getTableName();
        String tableName =table.getName();
        String sql = "select * from "+tableName + "," + tableName_expand;
        List list = new ArrayList();
        try {
            list = EntityTableUtil.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
return list;
    }
}
