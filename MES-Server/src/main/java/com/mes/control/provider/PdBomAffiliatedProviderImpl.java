package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.utils.ExcelHandler;
import com.mes.common.utils.FileUtils;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.PdAttributeMapper;
import com.mes.control.mapper.PdBomAffiliatedMapper;
import com.mes.dubbo.interprovider.control.IPdBomAffiliatedProvider;
import com.mes.entity.control.PdAttribute;
import com.mes.entity.control.PdBomAffiliated;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 产品管理-BOM-附属信息
 */
public class PdBomAffiliatedProviderImpl extends BaseProviderImpl<PdBomAffiliated> implements IPdBomAffiliatedProvider {
    @Autowired
    @Qualifier("pdBomAffiliatedMapper")
    private PdBomAffiliatedMapper pdBomAffiliatedMapper;
    @Autowired
    @Qualifier("pdAttributeMapper")
   private PdAttributeMapper pdAttributeMapper;

    @Override
    public PdBomAffiliatedMapper getBaseInterfaceMapper() {
        return pdBomAffiliatedMapper;
    }

    @Override
    public boolean saveBomAffiliates(List<PdBomAffiliated> bomAffiliateds) throws DubboProviderException {
        boolean result = true;
        try {
            List<String> webData = Lists.newArrayList();
            List<String> dbData = Lists.newArrayList();
            List<String> createData = Lists.newArrayList();
            List<String> deleteData = Lists.newArrayList();
            webData = bomAffiliateds
                    .stream()
                    .map(PdBomAffiliated::getAttributeId).collect(Collectors.toList());
            createData = bomAffiliateds
                    .stream()
                    .map(PdBomAffiliated::getAttributeId).collect(Collectors.toList());
            Map<String, Object> query = Maps.newHashMap();
            query.put("bomProduceId", bomAffiliateds.get(0).getBomProduceId());
            List<PdBomAffiliated> bomAffiliatedList = this.findByMap(query);
            if (null != bomAffiliatedList) {
                dbData = bomAffiliatedList
                        .stream()
                        .map(PdBomAffiliated::getAttributeId).collect(Collectors.toList());
                deleteData = bomAffiliatedList
                        .stream()
                        .map(PdBomAffiliated::getAttributeId).collect(Collectors.toList());
            }
            createData.removeAll(dbData);
            deleteData.removeAll(webData);
            for (String id : deleteData) {
                for (PdBomAffiliated bomAffiliated : bomAffiliatedList) {
                    if (bomAffiliated.getAttributeId().equalsIgnoreCase(id)) {
                        this.pdBomAffiliatedMapper.deleteById(bomAffiliated.getId());
                    }
                }
            }
            for (String id : createData) {
                if (null != id) {
                    for (PdBomAffiliated bomAffiliated : bomAffiliateds) {
                        if (bomAffiliated.getAttributeId().equalsIgnoreCase(id)) {
                            super.save(bomAffiliated);
                        }
                    }
                }
            }
        } catch (Exception e) {
            result = false;
            log.error("PdBomAffiliatedProviderImpl saveBomAffiliates is error ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean updateBomAffiliates(List<PdBomAffiliated> bomAffiliateds) throws DubboProviderException {
        boolean result = true;
        try {
            bomAffiliateds.forEach(bomAffiliated -> {
                try {
                    super.update(bomAffiliated);
                } catch (DubboProviderException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            result = false;
            log.error("PdBomAffiliatedProviderImpl updateBomAffiliates is error ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<PdBomAffiliated> findAffiliates(String pdId, String attrKey, String bomProduceId) throws DubboProviderException {
        Map<String, Object> params = Maps.newHashMap();
        params.put("pdId", pdId);
        params.put("attrKey", attrKey);
        params.put("bomProduceId", bomProduceId);
        return getByAttrKey(params);
    }

    @Override
    public List<PdBomAffiliated> getByAttrKey(Map<String, Object> map) throws DubboProviderException {
        return pdBomAffiliatedMapper.getByAttrKey(map);
    }

    /**
     * 单项配置模板导出
     * @param queryMap
     * @param file
     * @throws DubboProviderException
     * ledengyun--2017/09/26
     */
   public void downLoad(Map<String,Object> queryMap, File file)throws DubboProviderException{
    List<PdBomAffiliated> rows = pdBomAffiliatedMapper.downLoad(queryMap);
      Workbook workbook = new XSSFWorkbook();
       Sheet sheet = workbook.createSheet("单项配置");
           if (sheet != null && rows != null && !rows.isEmpty()) {
               Row r1 = sheet.createRow(0);
               r1.createCell(0).setCellValue("中文名");
               r1.createCell(1).setCellValue("键值key");
               r1.createCell(2).setCellValue("值value");
               for (int i = 1; i < rows.size()+1; i++) {
                   Row r = sheet.createRow(i);
                   for (int  j= 0; j <2; j++) {
                       r.createCell(j).setCellValue( rows.get(i-1).getName().toString());
                       j=j+1;
                      r.createCell(j).setCellValue(rows.get(i-1).getEnName().toString());
                       j=j+1;
                       r.createCell(j).setCellValue(rows.get(i-1).getValue().toString());
                   }
               }
           }
       FileOutputStream os = null;
       try {
           os = new FileOutputStream(file);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       try {
           workbook.write(os);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    /**
     * 单项配置EXCLE导入
     * @param path
     * @param pdId
     * @param bomProduceId
     * @throws DubboProviderException
     * lednegyun--2017/09/27
     */
    public void upload(String path,String pdId,String bomProduceId)throws DubboProviderException{

       File file = new File(path);
        try {
            List<Map<String, Object>> rows = ExcelHandler.read(FileUtils.getExt(file), 0, new FileInputStream(file));
            rows.subList(1, rows.size()).stream().forEach(row -> {
                String bomAffiliatedId = null;
                List<PdAttribute> list = null;
                String value = row.get("column2").toString();
                Map map = new HashMap();
                map.put("name",row.get("column0").toString());
                map.put("key",row.get("column1").toString());
                map.put("pdId",pdId);
                list = pdAttributeMapper.findByMap(map);
                String attributeId = null;
                if(list.size()>0) {
                    attributeId= list.get(0).getId();
                }
               Map queryMap = new HashMap();
                queryMap.put("attributeId",attributeId);
                queryMap.put("bomProduceId",bomProduceId);
                List<PdBomAffiliated> list1 = pdBomAffiliatedMapper.findByMap(queryMap);
                PdBomAffiliated pdBomAffiliated = new PdBomAffiliated();
                if(list1.size()>0){
                    bomAffiliatedId = list1.get(0).getId();
                    pdBomAffiliated.setId(bomAffiliatedId);
                    pdBomAffiliated.setValue(value);
                    pdBomAffiliatedMapper.update(pdBomAffiliated);

                }else {
                    bomAffiliatedId = IDGenerator.getID();
                    pdBomAffiliated.setId(bomAffiliatedId);
                    pdBomAffiliated.setAttributeId(attributeId);
                    pdBomAffiliated.setBomProduceId(bomProduceId);
                    pdBomAffiliated.setValue(value);
                    pdBomAffiliated.setCreateDate(new Date());
                    pdBomAffiliatedMapper.save(pdBomAffiliated);
                }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
