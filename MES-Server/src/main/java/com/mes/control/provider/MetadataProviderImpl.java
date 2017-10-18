package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.spring.ServiceBeanContext;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.ExpandTableConfigMapper;
import com.mes.control.mapper.MetadataMapper;
import com.mes.control.mapper.TableMapper;
import com.mes.control.utils.EntityTableUtil;
import com.mes.dubbo.interprovider.control.IMetadataProvider;
import com.mes.entity.control.ExpandTableConfig;
import com.mes.entity.control.Metadata;
import com.mes.entity.control.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by xiuyou.xu on 2017/7/6.
 */
public class MetadataProviderImpl extends BaseProviderImpl<Metadata> implements IMetadataProvider {
    @Autowired
    @Qualifier("metadataMapper")
    private MetadataMapper metadataMapper;
    @Autowired
    @Qualifier("tableMapper")
    private TableMapper tableMapper;
    @Autowired
    @Qualifier("expandTableConfigMapper")
    private ExpandTableConfigMapper expandTableConfigMapper;

    @Override
    public MetadataMapper getBaseInterfaceMapper() {
        return metadataMapper;
    }


    /**
     * 字段保存方法
     */

    public String saveFieldList(String tableId, List<Metadata> list) throws DubboProviderException {
        String tableName = null;
        String sql = null;
        boolean flag = false;
        String id = null;
        Table table = tableMapper.findById(tableId);
        tableName =table.getName();
        try {
            sql = EntityTableUtil.getCreateSql(list, tableName);
            flag = EntityTableUtil.actionSql(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag) {
            for (Metadata metadata : list) {
                metadata.setTableId(tableId);
                id = IDGenerator.getID();
                metadata.setId(id);
                metadataMapper.save(metadata);
            }
            table.setId(tableId);
            table.setIsCreate("1");
            tableMapper.update(table);
        }
        return id;
    }

    /**
     * 查询字段信息
     *
     * @param tableId
     * @param isExpand
     * @return
     * @throws DubboProviderException
     */
    public List<Metadata> findByTableId(String tableId, String isExpand) throws DubboProviderException {
        List<Metadata> list = null;
        if (isExpand.equals("1")) {
            ExpandTableConfig expandTableConfig = expandTableConfigMapper.findByTableId(tableId);
            if (null != expandTableConfig) {
                list = metadataMapper.findByTableId(expandTableConfig.getId());
            }
        } else {
            list = metadataMapper.findByTableId(tableId);
        }
        return list;

    }
}
