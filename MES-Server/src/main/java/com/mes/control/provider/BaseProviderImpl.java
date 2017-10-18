package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.domain.TrackableEntity;
import com.mes.common.framework.dubbo.impl.DubboBaseInterfaceImpl;
import com.mes.common.framework.mapper.BaseSQLInterfaceMapper;
import com.mes.control.mapper.BaseSQLMapper;
import com.mes.control.mapper.ExpandTableConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by xiuyou.xu on 2017/7/5.
 */
public abstract class BaseProviderImpl<T extends TrackableEntity> extends DubboBaseInterfaceImpl<T> {
    @Autowired
    @Qualifier("baseSQLMapper")
    private BaseSQLMapper baseSQLMapper;

    @Autowired
    @Qualifier("expandTableConfigMapper")
    private ExpandTableConfigMapper expandTableConfigMapper;

    @Override
    public BaseSQLInterfaceMapper getBaseSQLInterfaceMapper() {
        return baseSQLMapper;
    }

    @Override
    public String getExpandTableName(String entityClass) throws DubboProviderException {
        return expandTableConfigMapper.getExpandTableName(entityClass);
//        SQLVO sqlvo = new SQLVO();
//        sqlvo.setSql("SELECT c.table_name FROM mes_table t, mes_expand_table_config c WHERE t.entity_class = '" + entityClass + "' AND t.id = c.table_id");
//        List<LinkedHashMap<String, Object>> ret = baseSQLMapper.findToSql(sqlvo);
//        if (ret != null && !ret.isEmpty()) {
//            return ret.get(0).get("table_name").toString();
//        }
//        return null;
    }

    @Override
    public String getExpandTablePkColumnName(String expandTableName) throws DubboProviderException {
        return expandTableConfigMapper.getExpandTablePkColumnName(expandTableName);
//        SQLVO sqlvo = new SQLVO();
//        sqlvo.setSql("SELECT m.name FROM mes_expand_table_config c, mes_metadata m WHERE c.table_name='" + expandTableName + "' AND c.fk_column_id=m.id");
//        List<LinkedHashMap<String, Object>> ret = baseSQLMapper.findToSql(sqlvo);
//        if (ret != null && !ret.isEmpty()) {
//            return ret.get(0).get("name").toString();
//        }
//        return null;
    }
}
