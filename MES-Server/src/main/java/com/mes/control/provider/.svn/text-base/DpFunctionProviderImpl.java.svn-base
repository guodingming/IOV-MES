package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.utils.FileUtils;
import com.mes.control.mapper.DpFunctionMapper;
import com.mes.control.utils.ComInterfacesUtil;
import com.mes.dubbo.interprovider.control.IDpFunctionProvider;
import com.mes.entity.control.DpFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.File;
import java.util.List;

/**
 * 开发平台-脚本
 */
public class DpFunctionProviderImpl extends BaseProviderImpl<DpFunction> implements IDpFunctionProvider {
    @Autowired
    @Qualifier("dpFunctionMapper")
    private DpFunctionMapper dpFunctionMapper;

    @Override
    public DpFunctionMapper getBaseInterfaceMapper() {
        return dpFunctionMapper;
    }

    @Override
    public DpFunction findByBySourceType(String sourceType) throws DubboProviderException {
        ComInterfacesUtil.ServiceConfigs serviceConfigs = ComInterfacesUtil.getServiceConfigs();
        if (serviceConfigs != null) {
            ComInterfacesUtil.SourceTypes sourceTypes = serviceConfigs.getSourceTypes();
            if (sourceTypes != null) {
                List<ComInterfacesUtil.Type> types = sourceTypes.getTypes();
                if (types != null && !types.isEmpty()) {
                    for (ComInterfacesUtil.Type type : types) {
                        if (sourceType.equals(type.getName())) {
                            return dpFunctionMapper.findById(type.getHandlerId());
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean update(DpFunction entity) throws DubboProviderException {
        try {
            //保存脚本到文件
            DpFunction function = this.dpFunctionMapper.findById(entity.getId());
            if (null != function) {
                String path = ConfigHelper.getValue("shared.fs.dir");
                File groovy = new File(path + "/function-script/" +function.getName()+"_"+function.getId()+"/"+function.getName()+".groovy");
                FileUtils.write(entity.getScript(), groovy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.update(entity);
    }
}
