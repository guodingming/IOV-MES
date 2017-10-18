package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.utils.ExcelHandler;
import com.mes.common.utils.FileUtils;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.DpProduceDemarcateMapper;
import com.mes.control.mapper.FtyProcessMapper;
import com.mes.dubbo.interprovider.control.IDpProduceDemarcateProvider;
import com.mes.entity.control.DpProduceChip;
import com.mes.entity.control.DpProduceDemarcate;
import com.mes.entity.control.FtyProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-产品标定
 * Created by xiuyou.xu on 2017/08/30.
 */
public class DpProduceDemarcateProviderImpl extends BaseProviderImpl<DpProduceDemarcate> implements IDpProduceDemarcateProvider {
    private static Logger logger = LoggerFactory.getLogger(DpProduceDemarcateProviderImpl.class);

    @Autowired
    @Qualifier("dpProduceDemarcateMapper")
    private DpProduceDemarcateMapper dpProduceDemarcateMapper;

    @Autowired
    @Qualifier("ftyProcessMapper")
    private FtyProcessMapper ftyProcessMapper;

    @Override
    public DpProduceDemarcateMapper getBaseInterfaceMapper() {
        return dpProduceDemarcateMapper;
    }

    @Override
    public boolean saveImport(String path, String produceProcessId) {
        dpProduceDemarcateMapper.deleteByProduceProcessId(produceProcessId);
        File file = new File(ConfigHelper.getValue("shared.fs.dir") + path);
        try (InputStream is = new FileInputStream(file)) {
            List<Map<String, Object>> demarcates = ExcelHandler.read(FileUtils.getExt(file), 0, is);
            if (demarcates != null && !demarcates.isEmpty()) {
                for (int i = 1; i < demarcates.size(); i++) {
                    Map<String, Object> op = demarcates.get(i);
                    DpProduceDemarcate demarcate = new DpProduceDemarcate();
                    demarcate.setProduceProcessId(produceProcessId);
                    demarcate.setSdId(StringUtils.toString(op.get("column0")));
                    demarcate.setSdName(StringUtils.toString(op.get("column1")));
                    demarcate.setSdData(StringUtils.toString(op.get("column2")));
                    demarcate.setOrder((long) i);
                    try {
                        super.save(demarcate);
                    } catch (DubboProviderException e) {
                        e.printStackTrace();
                    }
                }
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("error creating input stream from file: " + file, e);
        } finally {
            file.delete();
        }
        return false;
    }


    @Override
    public List<Map<String, Object>> getDownload(String produceProcessId) {
        List<DpProduceDemarcate> data = dpProduceDemarcateMapper.findByProduceProcessId(produceProcessId);
        List<Map<String, Object>> rows = Lists.newArrayList();
        Map<String, Object> head = Maps.newHashMap();
        head.put("column0", "sd_id");
        head.put("column1", "sd_name");
        head.put("column2", "sd_data");
        rows.add(head);
        if (data != null && !data.isEmpty()) {
            for (int i = 0; i < data.size(); i++) {
                DpProduceDemarcate d = data.get(i);
                Map<String, Object> row = Maps.newHashMap();
                row.put("column0", d.getSdId());
                row.put("column1", d.getSdName());
                row.put("column2", d.getSdData());
                rows.add(row);
            }
        }

        return rows;
    }
}
