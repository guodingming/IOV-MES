package com.mes.common.framework.dubbo;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.domain.TrackableEntity;
import com.mes.common.framework.rest.view.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * dubbo抽象接口，  所有dubbo的接口都需要继承
 *
 * @param <Entity>
 */
public interface DubboBaseInterface<Entity extends TrackableEntity> {

    /**
     * 分页查询
     *
     * @param page
     * @param map
     * @return
     * @throws DubboProviderException
     */
    public Page findByPage(Page page, Map<String, Object> map) throws DubboProviderException;

    /**
     * 持久化对象的信息
     *
     * @param entity
     * @return
     * @throws DubboProviderException
     */
    public String save(Entity entity) throws DubboProviderException;

    /**
     * 修改对象的信息
     *
     * @param entity
     * @return
     * @throws DubboProviderException
     */
    public boolean update(Entity entity) throws DubboProviderException;

    /**
     * 根据ID 删除指定的对象
     *
     * @param id
     * @return
     * @throws DubboProviderException
     */
    public boolean deleteById(String id) throws DubboProviderException;

    /**
     * 根据ID 查找指定的对象
     *
     * @param id
     * @return
     * @throws DubboProviderException
     */
    public Entity findById(String id) throws DubboProviderException;

    /**
     * 得到所有的对象
     *
     * @return
     * @throws DubboProviderException
     */
    public List<Entity> findAll() throws DubboProviderException;

    /**
     * 返回结果为MAP
     *
     * @return
     * @throws DubboProviderException
     */
    public List<HashMap<String, Object>> findAllTMap() throws DubboProviderException;


    /**
     * 用于多条件查询
     *
     * @param map
     * @return
     * @throws DubboProviderException
     */
    public List<Entity> findByMap(Map<String, Object> map) throws DubboProviderException;


    /**
     * 根据条件查询记录数
     *
     * @param params
     * @return
     */
    public int countByCondition(Map<String, Object> params) throws DubboProviderException;
}
