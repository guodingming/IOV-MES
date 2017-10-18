package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.utils.ExcelHandler;
import com.mes.common.utils.FileUtils;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.DpProduceStandardTestOrderMapper;
import com.mes.dubbo.interprovider.control.IDpProduceStandardTestOrderProvider;
import com.mes.entity.control.DpProduceStandardTestOrder;
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
 * 开发平台-产品测试标准-测试顺序
 * Created by xiuyou.xu on 2017/7/4.
 */
public class DpProduceStandardTestOrderProviderImpl extends BaseProviderImpl<DpProduceStandardTestOrder> implements IDpProduceStandardTestOrderProvider {
    private static Logger logger = LoggerFactory.getLogger(DpProduceStandardTestOrderProviderImpl.class);

    @Autowired
    @Qualifier("dpProduceStandardTestOrderMapper")
    private DpProduceStandardTestOrderMapper dpProduceStandardTestOrderMapper;

    @Override
    public DpProduceStandardTestOrderMapper getBaseInterfaceMapper() {
        return dpProduceStandardTestOrderMapper;
    }

    @Override
    public boolean saveImport(String path, String produceProcessId) {
        dpProduceStandardTestOrderMapper.deleteByProduceProcessId(produceProcessId);
        File file = new File(ConfigHelper.getValue("shared.fs.dir") + path);
        try (InputStream is = new FileInputStream(file)) {
            List<Map<String, Object>> testOrderRows = ExcelHandler.read(FileUtils.getExt(file), 0, is);
            if (testOrderRows != null && !testOrderRows.isEmpty()) {
                for (int i = 1; i < testOrderRows.size(); i++) {
                    Map<String, Object> op = testOrderRows.get(i);
                    DpProduceStandardTestOrder order = new DpProduceStandardTestOrder();
                    order.setProduceProcessId(produceProcessId);
                    order.setName(StringUtils.toString(op.get("column0")));
                    order.setOrder(StringUtils.toString(op.get("column1")));
                    order.setSignal(StringUtils.toString(op.get("column2")));
                    order.setDataOrder(i);

                    try {
                        super.save(order);
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
        List<DpProduceStandardTestOrder> data = dpProduceStandardTestOrderMapper.findByProduceProcessId(produceProcessId);
        List<Map<String, Object>> rows = Lists.newArrayList();
        Map<String, Object> head = Maps.newHashMap();
        head.put("column0", "name");
        head.put("column1", "order");
        head.put("column2", "signal");
        rows.add(head);
        if (data != null && !data.isEmpty()) {
            for (int i = 0; i < data.size(); i++) {
                DpProduceStandardTestOrder d = data.get(i);
                Map<String, Object> row = Maps.newHashMap();
                row.put("column0", d.getName());
                row.put("column1", d.getOrder());
                row.put("column2", d.getSignal());
                rows.add(row);
            }
        }

        return rows;
    }
}
