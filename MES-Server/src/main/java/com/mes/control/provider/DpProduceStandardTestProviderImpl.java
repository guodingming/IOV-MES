package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.utils.ExcelHandler;
import com.mes.common.utils.FileUtils;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.DpProduceStandardTestMapper;
import com.mes.dubbo.interprovider.control.IDpProduceStandardTestProvider;
import com.mes.entity.control.DpProduceStandardTest;
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
 * 开发平台-产品测试标准
 * Created by xiuyou.xu on 2017/7/4.
 */
public class DpProduceStandardTestProviderImpl extends BaseProviderImpl<DpProduceStandardTest> implements IDpProduceStandardTestProvider {
    private static Logger logger = LoggerFactory.getLogger(DpProduceStandardTestProviderImpl.class);

    @Autowired
    @Qualifier("dpProduceStandardTestMapper")
    private DpProduceStandardTestMapper dpProduceStandardTestMapper;

    @Override
    public DpProduceStandardTestMapper getBaseInterfaceMapper() {
        return dpProduceStandardTestMapper;
    }

    @Override
    public boolean saveImport(String path, String produceProcessId) {
        dpProduceStandardTestMapper.deleteByProduceProcessId(produceProcessId);
        File file = new File(ConfigHelper.getValue("shared.fs.dir") + path);
        try (InputStream is = new FileInputStream(file)) {
            List<Map<String, Object>> testStandardRows = ExcelHandler.read(FileUtils.getExt(file), 0, is);
            if (testStandardRows != null && !testStandardRows.isEmpty()) {
                for (int i = 1; i < testStandardRows.size(); i++) {
                    Map<String, Object> op = testStandardRows.get(i);
                    DpProduceStandardTest test = new DpProduceStandardTest();
                    test.setProduceProcessId(produceProcessId);
                    //将测试标准的ti_id字段一起保存进来
                    test.setTiId(StringUtils.toString(op.get("column0")));
                    test.setTiName(StringUtils.toString(op.get("column1")));
                    test.setTiStandard(StringUtils.toString(op.get("column2")));
                    test.setTiUpper(StringUtils.toString(op.get("column3")));
                    test.setTiLower(StringUtils.toString(op.get("column4")));
                    test.setOrder(i);

                    try {
                        super.save(test);
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
        List<DpProduceStandardTest> data = dpProduceStandardTestMapper.findByProduceProcessId(produceProcessId);
        List<Map<String, Object>> rows = Lists.newArrayList();
        Map<String, Object> head = Maps.newHashMap();
        head.put("column0", "ti_id");
        head.put("column1", "ti_name");
        head.put("column2", "ti_standard");
        head.put("column3", "ti_upper");
        head.put("column4", "ti_lower");
        rows.add(head);
        if (data != null && !data.isEmpty()) {
            for (int i = 0; i < data.size(); i++) {
                DpProduceStandardTest d = data.get(i);
                Map<String, Object> row = Maps.newHashMap();
                row.put("column0", d.getTiId());
                row.put("column1", d.getTiName());
                row.put("column2", d.getTiStandard());
                row.put("column3", d.getTiUpper());
                row.put("column4", d.getTiLower());
                rows.add(row);
            }
        }

        return rows;
    }
}
