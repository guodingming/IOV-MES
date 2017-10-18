package com.mes.dubbo.interprovider.control;

import com.mes.entity.control.PdBomProduce;

import java.io.InputStream;

/**
 * 文件传输接口，负责消费端和提供端进行文件数据传输
 *
 * Created by xiuyou.xu on 2017/7/21.
 */
public interface IFileTransferProvider {

    String saveUploadProductBom(PdBomProduce bomProduce, InputStream fileStream);
}
