package com.mes.common.framework.mapper;

import java.util.List;
import java.util.Map;


/**
 * 持久化接口
 *
 * @param <Entity>
 */
public interface BaseInterfaceMapper<Entity>  {

    public void save(Entity entity);

    public void update(Entity entity);

    public void deleteById(String id);

    public Entity findById(String id);

    public List<Entity> findAll();

    public List<Entity> findByMap(Map<String, Object> map);

    public Integer getCount(Map<String, Object> map);

    public List<Entity> findByPage(Map<String, Object> map);

    public List<Entity> findByName(Map<String, Object> map);


}
