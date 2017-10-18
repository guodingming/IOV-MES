package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.ExpandTableConfigMapper;
import com.mes.control.mapper.MetadataMapper;
import com.mes.control.mapper.TableMapper;
import com.mes.control.utils.EntityTableUtil;
import com.mes.dubbo.interprovider.control.IExpandTableConfigProvider;
import com.mes.entity.control.ExpandTableConfig;
import com.mes.entity.control.Metadata;
import com.mes.entity.control.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by xiuyou.xu on 2017/7/6.
 */
public class ExpandTableConfigProviderImpl extends BaseProviderImpl<ExpandTableConfig> implements IExpandTableConfigProvider {
    @Autowired
    @Qualifier("expandTableConfigMapper")
    private ExpandTableConfigMapper expandTableConfigMapper;
    @Autowired
    @Qualifier("tableMapper")
    private TableMapper tableMapper;
    @Autowired
    @Qualifier("metadataMapper")
    private MetadataMapper metadataMapper;

    @Override
    public ExpandTableConfigMapper getBaseInterfaceMapper() {
        return expandTableConfigMapper;
    }

    /**
     * 扩展对象添加
     * @param tableId
     * @param list
     * @return
     * @throws DubboProviderException
     */
    public String saveExpandField(String tableId, List<Metadata>list)throws DubboProviderException{
        String tableName = null;
        String sql = null;
        String fkId = null;
        boolean flag = false;
        String id = null;
        Table table = tableMapper.findById(tableId);
       boolean ff = table.getIsCreate().equals("1");
       if(ff) {
           boolean ft=false;
           ExpandTableConfig ee=expandTableConfigMapper.findByTableId(tableId);
           if(ee ==null){
               ft = true;
           }
           //扩展表不存在时创建扩展表并保存字段信息
           if(ft) {
               tableName = "expand_" + table.getName();
                   id = IDGenerator.getID();
                   for (Metadata metadata : list) {//保存扩展对象的字段信息
                       metadata.setTableId(id);
                       String idd = IDGenerator.getID();
                       metadata.setId(idd);
                       metadataMapper.save(metadata);
                       if (metadata.getColumn().equals("id")) {
                           fkId = idd;
                       }
                   }
                   // 保存扩展对象信息记录
                   ExpandTableConfig expandTableConfig = new ExpandTableConfig();
                   expandTableConfig.setId(id);
                   expandTableConfig.setFkColumnId(fkId);
                   expandTableConfig.setTableId(tableId);
                   expandTableConfig.setTableName(tableName);
                   expandTableConfigMapper.save(expandTableConfig);
                   //修改主表信息的状态
                   table.setId(tableId);
                   table.setIsCreateExpand("1");
                   tableMapper.update(table);

               try {
                   sql = EntityTableUtil.getCreateSql(list, tableName);
                  flag = EntityTableUtil.actionSql(sql);
               } catch (Exception e) {
                   expandTableConfigMapper.deleteById(id);
                   metadataMapper.deleteByTableId(id);
                   log.error("扩展表创建失败");
                   e.printStackTrace();
               }
           } else {//扩展表已经存在，追加扩展字段时
               tableName = ee.getTableName();
               try {
                   sql = EntityTableUtil.getAddColumSql(list, tableName);
                  flag =  EntityTableUtil.actionSql(sql);
               } catch (Exception e) {
                   log.error("扩展字段追加失败");
                   e.printStackTrace();
               }
               if(flag) {
                   id = ee.getId();
                   for (Metadata metadata : list) {//保存字段信息
                       metadata.setTableId(id);
                       String idd = IDGenerator.getID();
                       metadata.setId(idd);
                       metadataMapper.save(metadata);

                   }
               }
           }
       }else {
           log.error("主表未创建");
       }

    return id;
    }

    public ExpandTableConfig findByTableId(String tableId) throws DubboProviderException{

        ExpandTableConfig expandTableConfig = expandTableConfigMapper.findByTableId(tableId);
        return expandTableConfig;


    }
}
