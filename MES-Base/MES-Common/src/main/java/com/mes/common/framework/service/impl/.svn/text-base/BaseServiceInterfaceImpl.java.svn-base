package com.mes.common.framework.service.impl;

import com.google.common.collect.Lists;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.domain.TrackableEntity;
import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.framework.service.BaseServiceInterface;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/6/20.
 */
public abstract class BaseServiceInterfaceImpl<Entity extends TrackableEntity> implements BaseServiceInterface<Entity> {
    protected Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Page findByPage(Page page, Map<String, Object> map) throws DubboProviderException {
        Page pageLoad = page;
        try {
            pageLoad.setTotal(this.getBaseInterfaceMapper().getCount(map));
//            map.put("pageNum",page.getPageNum());
            map.put("startRowNum",page.getStartRowNum());
            map.put("pageSize",page.getPageSize());
//            map.put("endRowNum",page.getEndRowNum());
            pageLoad.setRows(this.getBaseInterfaceMapper().findByPage(map));
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl findByPage ", e);
            throw new DubboProviderException(e.getMessage(),e);
        }
        return pageLoad;
    }

    @Override
    public String save(Entity entity) throws DubboProviderException {
        String id = entity.getId();

        try {
            if(StringUtils.isBlank(id)) {
                id = IDGenerator.getID();
                entity.setId(id);
            }
            entity.setCreateDate(new Date());
            this.getBaseInterfaceMapper().save(entity);
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl save ",e);
            throw new DubboProviderException(e.getMessage(),e);
        }
        return id;
    }

    @Override
    public boolean update(Entity entity) throws DubboProviderException {
        boolean flag = true;
        try {
            entity.setUpdateDate(new Date());
            this.getBaseInterfaceMapper().update(entity);
        } catch (Exception e) {
            flag = false;
            log.error("DubboBaseInterfaceImpl update ", e);
            throw new DubboProviderException(e.getMessage(),e);
        }
        return flag;
    }

    @Override
    public boolean deleteById(String id) throws DubboProviderException {
        boolean flag = true;
        try {
            this.getBaseInterfaceMapper().deleteById(id);
        } catch (Exception e) {
            flag = false;
            log.error("DubboBaseInterfaceImpl deleteById ", e);
            throw new DubboProviderException(e.getMessage(),e);
        }
        return flag;
    }

    @Override
    public Entity findById(String id) throws DubboProviderException {
        Entity  entity = null;
        try {
            entity =  this.getBaseInterfaceMapper().findById(id);
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl findById ", e);
            throw new DubboProviderException(e.getMessage(),e);
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
            throw new DubboProviderException(e.getMessage(),e);
        }
        return list;
    }

    @Override
    public List<Entity> findByMap(Map<String, Object> map) throws DubboProviderException {
        List<Entity> list = Lists.newArrayList();
        try {
            list = this.getBaseInterfaceMapper().findByMap(map);
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl findByMap", e);
            throw new DubboProviderException(e.getMessage(),e);
        }
        return list;
    }

    /**
     * 抽象方法需要实现，  得到基础服务接口
     * @return
     */
    public abstract BaseInterfaceMapper<Entity> getBaseInterfaceMapper();

}