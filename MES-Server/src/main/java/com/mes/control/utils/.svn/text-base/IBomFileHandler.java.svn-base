package com.mes.control.utils;

import com.mes.entity.control.PdBomMaterialAmount;

import java.util.List;
import java.util.Map;

/**
 * bom文件处理，输入为已读取转化为List<Map>的bom文件数据（List每个元素为bom文件的一行），输出为每行对应的物料及其用量等信息，封装到PdBomMaterialAmount中
 * Created by xiuyou.xu on 2017/7/21.
 */
public interface IBomFileHandler {
    /**
     *
     * @param bomId 生产bom id
     * @param rows 已转化为List<Map>的bom文件数据（List每个元素为bom文件的一行）
     * @return
     */
    List<PdBomMaterialAmount> handle(String bomId, List<Map<String, Object>> rows);
}
