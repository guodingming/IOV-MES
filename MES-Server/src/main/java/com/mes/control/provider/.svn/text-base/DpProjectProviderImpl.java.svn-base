package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DpProjectMapper;
import com.mes.dubbo.interprovider.control.IDpProjectProvider;
import com.mes.entity.control.DpProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;

/**
 * 开发平台--开发工程
 */
public class DpProjectProviderImpl extends BaseProviderImpl<DpProject> implements IDpProjectProvider {
    @Autowired
    @Qualifier("dpProjectMapper")
    private DpProjectMapper dpProjectMapper;

    @Override
    public DpProjectMapper getBaseInterfaceMapper() {
        return dpProjectMapper;
    }

    @Override
    public boolean updateEnable(String ids, int enable) throws DubboProviderException {
        try {
            if (ids != null && !ids.isEmpty()) {
                String[] idArr = ids.split(",");
                DpProject project = new DpProject();
                project.setIsEnabled(enable);
                for (String id : idArr) {
                    project.setId(id);
                    project.setEnabledTime(new Date());
                    dpProjectMapper.update(project);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DubboProviderException(e);
        }
    }

    @Override
    public boolean updateRelease(String ids, int release) throws DubboProviderException {
        try {
            if (ids != null && !ids.isEmpty()) {
                String[] idArr = ids.split(",");
                DpProject project = new DpProject();
                project.setIsRelease(release);
                for (String id : idArr) {
                    project.setId(id);
                    project.setReleaseTime(new Date());
                    dpProjectMapper.update(project);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DubboProviderException(e);
        }
    }
}
