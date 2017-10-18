package com.mes.control.provider;

import com.mes.dubbo.interprovider.control.IFileTransferProvider;
import com.mes.entity.control.PdBomProduce;

import java.io.InputStream;

/**
 * 文件传输接口，负责消费端和提供端进行文件数据传输
 *
 * Created by xiuyou.xu on 2017/7/21.
 */
public class FileTransferProviderImpl implements IFileTransferProvider {
    @Override
    public String saveUploadProductBom(PdBomProduce bomProduce, InputStream fileStream) {

        return null;
    }
}
