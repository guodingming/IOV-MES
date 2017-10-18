package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.view.Page;
import com.mes.control.mapper.DpServiceLogMapper;
import com.mes.control.mapper.DpServiceMapper;
import com.mes.control.utils.LogUtil;
import com.mes.dubbo.interprovider.control.IDpServiceLogProvider;
import com.mes.entity.control.DpService;
import com.mes.entity.control.DpServiceLog;
import com.mes.entity.control.ServiceMonitorLineData;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-服务日志
 */
public class DpServiceLogProviderImpl extends BaseProviderImpl<DpServiceLog> implements IDpServiceLogProvider {
    @Autowired
    @Qualifier("dpServiceLogMapper")
    private DpServiceLogMapper dpServiceLogMapper;

    @Autowired
    @Qualifier("dpServiceMapper")
    private DpServiceMapper dpServiceMapper;

    @Override
    public DpServiceLogMapper getBaseInterfaceMapper() {
        return dpServiceLogMapper;
    }

    @Override
    public Page findByPage(Page page, Map<String, Object> map) {
        String code = "";
        if (map.get("serviceId") != null && !map.get("serviceId").toString().isEmpty()) {
            String serviceId = (String) map.get("serviceId");
            String search = (String) map.get("search");
            DpService service = dpServiceMapper.findById(serviceId);
            code = service.getCode();

            map.clear();
            map.put("path", search);
            map.put("tookTime", search);
            map.put("startTime", search);
            map.put("params", search);
            map.put("status", search);

            page.setCondition(map);
        } else {
            map.remove("serviceId");
            String search = (String) map.get("search");
            map.clear();
            map.put("path", search);
            map.put("tookTime", search);
            map.put("startTime", search);
            map.put("params", search);
            map.put("status", search);

            page.setCondition(map);
        }
        page.setStartRowNum((page.getPageNum() - 1) * page.getPageSize());
        SortBuilder sortBuilder = SortBuilders.fieldSort("startTime").order(SortOrder.DESC);
        return LogUtil.query(page, ConfigHelper.getValue("es.service.invocation.index"), ConfigHelper.getValue("es.service.invocation.type"), code, sortBuilder);
    }

    @Override
    public ServiceMonitorLineData queryLineData(String serviceId, String year, String month) {
        ServiceMonitorLineData lineData = new ServiceMonitorLineData();
        ServiceMonitorLineData.LineData yearLine = new ServiceMonitorLineData.LineData();
        ServiceMonitorLineData.LineData monthLine = new ServiceMonitorLineData.LineData();
        lineData.setYearLine(yearLine);
        lineData.setMonthLine(monthLine);

        SimpleDateFormat monthSdf = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat daySdf = new SimpleDateFormat("yyyy-MM-dd");

        int year1 = Integer.parseInt(year);
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.YEAR, year1);
        c1.set(Calendar.MONTH, 0);
        c1.set(Calendar.DATE, 1);
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);
        c1.set(Calendar.MILLISECOND, 0);
        Date d1 = c1.getTime();
        c1.add(Calendar.YEAR, 1);
        c1.add(Calendar.DATE, -1);
        Date d2 = c1.getTime();

        List<Map<String, Object>> data1 = dpServiceLogMapper.query(serviceId, d1, d2, "m", 1);
        List<Map<String, Object>> data2 = dpServiceLogMapper.query(serviceId, d1, d2, "m", 0);
        if (data1 != null && !data1.isEmpty()) {
            List<String> labels = Lists.newArrayList();
            List<Long> successes = Lists.newArrayList();
            List<Long> fails = Lists.newArrayList();
            data1.stream().forEach(d -> {
                labels.add(monthSdf.format(d.get("period_start")));
                successes.add((Long) d.get("count"));
            });
            data2.stream().forEach(d -> {
                fails.add((Long) d.get("count"));
            });
            yearLine.setLabels(labels);
            yearLine.setSuccesses(successes);
            yearLine.setFails(fails);
        }

        String[] a = month.split("\\-");
        int year2 = Integer.parseInt(a[0]);
        int month2 = Integer.parseInt(a[1]);
        c1.set(Calendar.YEAR, year2);
        c1.set(Calendar.MONTH, month2 - 1);
        c1.set(Calendar.DATE, 1);
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);
        c1.set(Calendar.MILLISECOND, 0);
        d1 = c1.getTime();
        c1.add(Calendar.MONTH, 1);
        c1.add(Calendar.HOUR_OF_DAY, -1);
        d2 = c1.getTime();

        List<Map<String, Object>> data3 = dpServiceLogMapper.query(serviceId, d1, d2, "d", 1);
        List<Map<String, Object>> data4 = dpServiceLogMapper.query(serviceId, d1, d2, "d", 0);
        if (data3 != null && !data3.isEmpty()) {
            List<String> labels = Lists.newArrayList();
            List<Long> successes = Lists.newArrayList();
            List<Long> fails = Lists.newArrayList();
            data3.stream().forEach(d -> {
                labels.add(daySdf.format(d.get("period_start")));
                successes.add((Long) d.get("count"));
            });
            data4.stream().forEach(d -> {
                fails.add((Long) d.get("count"));
            });
            monthLine.setLabels(labels);
            monthLine.setSuccesses(successes);
            monthLine.setFails(fails);
        }


        return lineData;
    }
}
