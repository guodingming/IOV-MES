package com.mes.common.framework.dubbo.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.domain.TrackableEntity;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.dubbo.DubboBaseSQLInterface;
import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.common.framework.mapper.BaseSQLInterfaceMapper;
import com.mes.common.framework.mapper.BeanMapper;
import com.mes.common.framework.mapper.SQLVO;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public abstract class DubboBaseInterfaceImpl<Entity extends TrackableEntity> implements DubboBaseInterface<Entity>, DubboBaseSQLInterface {
    protected Logger log = LoggerFactory.getLogger(getClass());


    @Override
    public Page findByPage(Page page, Map<String, Object> map) throws DubboProviderException {
        Page pageLoad = page;
        try {
            pageLoad.setTotal(this.getBaseInterfaceMapper().getCount(map));
//            map.put("pageNum",page.getPageNum());
            map.put("startRowNum", page.getStartRowNum());
            map.put("pageSize", page.getPageSize());
//            map.put("endRowNum",page.getEndRowNum());
            pageLoad.setRows(this.getBaseInterfaceMapper().findByPage(map));
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl findByPage ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return pageLoad;
    }

    @Override
    public String save(Entity entity) throws DubboProviderException {
        String id = entity.getId();

        try {
            if (StringUtils.isBlank(id)) {
                id = IDGenerator.getID();
                entity.setId(id);
            }
            entity.setCreateDate(new Date());
            this.getBaseInterfaceMapper().save(entity);
            // 保存扩展表字段数据
            String expandTableName = getExpandTableName(entity.getClass().getName());
            Map<String, Object> expand = entity.getExpandMap();
            // 如果扩展表存在且扩展字段有值
            if (expandTableName != null && expand != null && !expand.isEmpty()) {
                expand.put(getExpandTablePkColumnName(expandTableName), id);
                String sql = ExpandTableUtil.getInsertSql(expandTableName, expand);
                this.saveToSql(sql);
            }
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl save ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return id;
    }

    @Override
    public boolean update(Entity entity) throws DubboProviderException {
        boolean flag = true;
        try {
            entity.setUpdateDate(new Date());
            this.getBaseInterfaceMapper().update(entity);
            // 更新扩展表字段数据
            String expandTableName = getExpandTableName(entity.getClass().getName());
            Map<String, Object> expand = entity.getExpandMap();
            // 如果扩展表存在且扩展字段有值
            if (expandTableName != null && expand != null && !expand.isEmpty()) {
                expand.put(getExpandTablePkColumnName(expandTableName), entity.getId());
                String sql = ExpandTableUtil.getUpdateSql(expandTableName, expand);
                this.updateToSql(sql);
            }
        } catch (Exception e) {
            flag = false;
            log.error("DubboBaseInterfaceImpl update ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return flag;
    }

    @Override
    public boolean deleteById(String id) throws DubboProviderException {
        boolean flag = true;
        try {
            Entity entity = this.getBaseInterfaceMapper().findById(id);
            this.getBaseInterfaceMapper().deleteById(id);
            if (entity != null) {
                // 删除扩展表数据
                String expandTableName = getExpandTableName(entity.getClass().getName());
                Map<String, Object> expand = Maps.newHashMap();
                // 如果扩展表存在且扩展字段有值
                if (expandTableName != null && expand != null && !expand.isEmpty()) {
                    expand.put(getExpandTablePkColumnName(expandTableName), id);
                    String sql = ExpandTableUtil.getDeleteSql(expandTableName, expand);
                    this.deleteToSql(sql);
                }
            }
        } catch (Exception e) {
            flag = false;
            log.error("DubboBaseInterfaceImpl deleteById ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return flag;
    }

    @Override
    public Entity findById(String id) throws DubboProviderException {
        Entity entity = null;
        try {
            entity = this.getBaseInterfaceMapper().findById(id);
            // 查询扩展表字段数据
            String expandTableName = getExpandTableName(entity.getClass().getName());
            // 如果扩展表存在
            if (expandTableName != null) {
                Map<String, Object> params = Maps.newHashMap();
                params.put(getExpandTablePkColumnName(expandTableName), id);
                String sql = ExpandTableUtil.getSelectSql(expandTableName, params);
                List<LinkedHashMap<String, Object>> expand = this.findToSql(sql);
                if (expand != null && !expand.isEmpty()) {
                    entity.setExpandMap(expand.get(0));
                }
            }
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl findById ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return entity;
    }

    @Override
    public List<Entity> findAll() throws DubboProviderException {
        List<Entity> list = Lists.newArrayList();
        try {
            list = this.getBaseInterfaceMapper().findAll();
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl findAll ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return list;
    }

    public List<HashMap<String, Object>> findAllTMap() throws DubboProviderException {
        List<HashMap<String, Object>> listMap = Lists.newArrayList();
        try {
            List<Entity> list = this.findAll();
            for (Entity one : list) {
                HashMap<String, Object> map = (HashMap<String, Object>) BeanMapper.beanToMap(one);
                listMap.add(map);
            }
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl findAll ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return listMap;
    }

    @Override
    public List<Entity> findByMap(Map<String, Object> map) throws DubboProviderException {
        List<Entity> list = Lists.newArrayList();
        try {
            list = this.getBaseInterfaceMapper().findByMap(map);
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl findByMap", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return list;
    }

    @Override
    public int countByCondition(Map<String, Object> params) throws DubboProviderException {
        return this.getBaseInterfaceMapper().getCount(params);
    }

    @Override
    public void saveToSql(String sql) throws DubboProviderException {
        try {
            SQLVO sqlvo = new SQLVO();
            sqlvo.setSql(sql);
            this.getBaseSQLInterfaceMapper().saveToSql(sqlvo);
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl saveToSql", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
    }

    @Override
    public void updateToSql(String sql) throws DubboProviderException {
        try {
            SQLVO sqlvo = new SQLVO();
            sqlvo.setSql(sql);
            this.getBaseSQLInterfaceMapper().updateToSql(sqlvo);
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl updateToSql", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteToSql(String sql) throws DubboProviderException {
        try {
            SQLVO sqlvo = new SQLVO();
            sqlvo.setSql(sql);
            this.getBaseSQLInterfaceMapper().deleteToSql(sqlvo);
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl deleteToSql", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
    }

    @Override
    public List<LinkedHashMap<String, Object>> findToSql(String sql) throws DubboProviderException {
        try {
            SQLVO sqlvo = new SQLVO();
            sqlvo.setSql(sql);
            return this.getBaseSQLInterfaceMapper().findToSql(sqlvo);
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl findToSql", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
    }

    @Override
    public Integer getCountToSql(String sql) throws DubboProviderException {
        try {
            SQLVO sqlvo = new SQLVO();
            sqlvo.setSql(sql);
            return this.getBaseSQLInterfaceMapper().getCountToSql(sqlvo);
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl getCountToSql", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
    }

    @Override
    public List<LinkedHashMap<String, Object>> findByPageToSql(String sql) throws DubboProviderException {
        try {
            SQLVO sqlvo = new SQLVO();
            sqlvo.setSql(sql);
            return this.getBaseSQLInterfaceMapper().findByPageToSql(sqlvo);
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl findByPageToSql", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
    }

    /**
     * 抽象方法需要实现，  得到基础服务接口
     *
     * @return
     */
    public abstract BaseInterfaceMapper<Entity> getBaseInterfaceMapper();

    /**
     * 得到sql方式操作数据的接口
     *
     * @return
     */
    public abstract BaseSQLInterfaceMapper getBaseSQLInterfaceMapper();
}
