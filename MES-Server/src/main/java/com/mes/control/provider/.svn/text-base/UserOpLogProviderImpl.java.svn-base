package com.mes.control.provider;

import com.alibaba.fastjson.JSON;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.common.framework.rest.view.Page;
import com.mes.control.utils.LogUtil;
import com.mes.dubbo.interprovider.control.IUserOpLogProvider;
import com.mes.entity.control.UserOpLog;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xiuyou.xu on 2017/7/27.
 */
public class UserOpLogProviderImpl extends BaseProviderImpl<UserOpLog> implements IUserOpLogProvider {
    private static Logger logger = LoggerFactory.getLogger(UserOpLogProviderImpl.class);

    /**
     * 保存用户操作日志，可以保存到数据库中或kafka中
     *
     * @param userOpLog
     * @return
     */
    @Override
    public String save(UserOpLog userOpLog) {
//        System.out.println(JSON.toJSONString(userOpLog));
        logger.info(JSON.toJSONString(userOpLog));
        return null;
    }

    @Override
    public BaseInterfaceMapper<UserOpLog> getBaseInterfaceMapper() {
        return null;
    }

    @Override
    public Page query(Page page) {
        page.setStartRowNum((page.getPageNum() - 1) * page.getPageSize());
        SortBuilder sortBuilder = SortBuilders.fieldSort("startTime").order(SortOrder.DESC);
        return LogUtil.query(page, ConfigHelper.getValue("es.user.op.index"), ConfigHelper.getValue("es.user.op.type"), sortBuilder);
    }
}
