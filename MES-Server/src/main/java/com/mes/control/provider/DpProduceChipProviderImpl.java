package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.utils.ExcelHandler;
import com.mes.common.utils.FileUtils;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.DpProduceChipMapper;
import com.mes.dubbo.interprovider.control.IDpProduceChipProvider;
import com.mes.entity.control.DpProduceChip;
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
 * 开发平台-产品芯片
 * Created by xiuyou.xu on 2017/7/4.
 */
public class DpProduceChipProviderImpl extends BaseProviderImpl<DpProduceChip> implements IDpProduceChipProvider {
    private static Logger logger = LoggerFactory.getLogger(DpProduceChipProviderImpl.class);

    @Autowired
    @Qualifier("dpProduceChipMapper")
    private DpProduceChipMapper dpProduceChipMapper;

    @Override
    public DpProduceChipMapper getBaseInterfaceMapper() {
        return dpProduceChipMapper;
    }

    @Override
    public boolean saveImport(String path, String produceProcessId) {
        dpProduceChipMapper.deleteByProduceProcessId(produceProcessId);
        File file = new File(ConfigHelper.getValue("shared.fs.dir") + path);
        try (InputStream is = new FileInputStream(file)) {
            List<Map<String, Object>> chipOps = ExcelHandler.read(FileUtils.getExt(file), 0, is);
            if (chipOps != null && !chipOps.isEmpty()) {
                for (int i = 1; i < chipOps.size(); i++) {
                    Map<String, Object> op = chipOps.get(i);
                    DpProduceChip chip = new DpProduceChip();
                    chip.setProduceProcessId(produceProcessId);
                    chip.setProcedureName(StringUtils.toString(op.get("column0")));
                    chip.setSerialId(StringUtils.toString(op.get("column1")));
                    chip.setAddr(StringUtils.toString(op.get("column2")));
                    chip.setByteNum(StringUtils.toString(op.get("column3")));
                    chip.setSourceTypeName(StringUtils.toString(op.get("column4")));
                    chip.setContent(StringUtils.toString(op.get("column5")));
                    chip.setStoreTypeName(StringUtils.toString(op.get("column6")));
                    chip.setOperCodeName(StringUtils.toString(op.get("column7")));
                    chip.setChipSequence(StringUtils.toString(op.get("column8")));
                    chip.setProgrammerTypeName(StringUtils.toString(op.get("column9")));
                    chip.setModelName(StringUtils.toString(op.get("column10")));
                    chip.setDelayTime(StringUtils.toString(op.get("column11")));
                    chip.setOperDescribe(StringUtils.toString(op.get("column12")));
                    chip.setOrder(i);

                    try {
                        super.save(chip);
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
        List<DpProduceChip> data = dpProduceChipMapper.findByProduceProcessId(produceProcessId);
        List<Map<String, Object>> rows = Lists.newArrayList();
        Map<String, Object> head = Maps.newHashMap();
        head.put("column0", "procedure_name");
        head.put("column1", "serial_id");
        head.put("column2", "addr");
        head.put("column3", "byte_num");
        head.put("column4", "source_type_name");
        head.put("column5", "content");
        head.put("column6", "store_type_name");
        head.put("column7", "oper_code_name");
        head.put("column8", "chip_sequence");
        head.put("column9", "programmer_type_name");
        head.put("column10", "model_name");
        head.put("column11", "delay_time");
        head.put("column12", "oper_describe");
        rows.add(head);
        if (data != null && !data.isEmpty()) {
            for (int i = 0; i < data.size(); i++) {
                DpProduceChip d = data.get(i);
                Map<String, Object> row = Maps.newHashMap();
                row.put("column0", d.getProcedureName());
                row.put("column1", d.getSerialId());
                row.put("column2", d.getAddr());
                row.put("column3", d.getByteNum());
                row.put("column4", d.getSourceTypeName());
                row.put("column5", d.getContent());
                row.put("column6", d.getStoreTypeName());
                row.put("column7", d.getOperCodeName());
                row.put("column8", d.getChipSequence());
                row.put("column9", d.getProgrammerTypeName());
                row.put("column10", d.getModelName());
                row.put("column11", d.getDelayTime());
                row.put("column12", d.getOperDescribe());
                rows.add(row);
            }
        }

        return rows;
    }
}
