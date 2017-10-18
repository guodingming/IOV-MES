package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DeptMapper;
import com.mes.control.mapper.UserMapper;
import com.mes.dubbo.interprovider.control.IDeptProvider;
import com.mes.entity.control.Dept;
import com.mes.entity.control.User;
import com.mes.entity.control.UserDeptAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
public class DeptProviderImpl extends BaseProviderImpl<Dept> implements IDeptProvider {

    @Autowired
    @Qualifier("deptMapper")
    private DeptMapper deptMapper;
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Override
    public DeptMapper getBaseInterfaceMapper() {
        return deptMapper;
    }

    @Override
    public void deleteAll() {
        deptMapper.deleteAll();
    }

    /**
     * 验证部门下是否有数据
     * @param id
     * @return
     * ledengyun--2017/10/14
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException{

        boolean flag = true;
        List<UserDeptAuth> list = deptMapper.findByDeptId(id);
        if(list.size()>0){
            flag = false;
        }
        return flag;
    }

}
