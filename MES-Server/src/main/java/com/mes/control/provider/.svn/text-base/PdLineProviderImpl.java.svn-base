package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.Node;
import com.mes.control.mapper.DpProduceProcessMapper;
import com.mes.control.mapper.PdLineMapper;
import com.mes.control.mapper.PdMapper;
import com.mes.control.mapper.PdWorkOrderMapper;
import com.mes.dubbo.interprovider.control.IPdLineProvider;
import com.mes.entity.control.DpProduceProcess;
import com.mes.entity.control.Pd;
import com.mes.entity.control.PdLine;
import com.mes.entity.control.PdWorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-产品线
 */
public class PdLineProviderImpl extends BaseProviderImpl<PdLine> implements IPdLineProvider {
    @Autowired
    @Qualifier("pdLineMapper")
    private PdLineMapper pdLineMapper;

    @Autowired
    @Qualifier("pdMapper")
    private PdMapper pdMapper;

    @Autowired
    @Qualifier("pdWorkOrderMapper")
    private PdWorkOrderMapper pdWorkOrderMapper;

    @Autowired
    @Qualifier("dpProduceProcessMapper")
    private DpProduceProcessMapper dpProduceProcessMapper;

    @Override
    public PdLineMapper getBaseInterfaceMapper() {
        return pdLineMapper;
    }

    public List<Pd> findByPdLineId(String pdLineId) throws DubboProviderException {
        List<Pd> list = null;
        list = pdMapper.findByPdLineId(pdLineId);
        return list;

    }

    @Override
    public List<Node> getPdLineTree() throws DubboProviderException {
        List<Node> nodes = Lists.newArrayList();
        List<PdLine> lines = pdLineMapper.findAll();
        if (lines != null && !lines.isEmpty()) {
            lines.stream().forEach(line -> {
                Node node = new Node();
                node.setId(line.getId());
                node.setName(line.getName());
                node.setData(line);

                List<Node> children = Lists.newArrayList();
                Map<String, Object> map = Maps.newHashMap();
                map.put("pdLineId", line.getId());
                List<Pd> pds = pdMapper.findByMap(map);
                if (pds != null && !pds.isEmpty()) {
                    pds.stream().forEach(pd -> {
                        Node n = new Node();
                        n.setId(pd.getId());
                        n.setName(pd.getName());
                        n.setData(pd);
                        n.setLeaf(true);

                        children.add(n);
                    });
                }
                node.setChildren(children);
                nodes.add(node);
            });
        }

        return nodes;
    }

    @Override
    public List<Node> loginPdInfo() throws DubboProviderException {
        List<Node> result = Lists.newArrayList();
        try {
            List<PdLine> pdLines = this.pdLineMapper.findAll();
            for (PdLine pdLine : pdLines) {
                Node pdLineNode = new Node();
                pdLineNode.setId(pdLine.getId());
                pdLineNode.setName(pdLine.getName());
                Map<String, Object> query = Maps.newHashMap();
                query.put("pdLineId", pdLine.getId());
                List<Pd> pds = this.pdMapper.findByMap(query);
                List<Node> lineChildrens = Lists.newArrayList();
                for (Pd pd : pds) {
                    Node pdNode = new Node();
                    pdNode.setId(pd.getId());
                    pdNode.setName(pd.getName());
                    query.clear();
                    query.put("pdId", pd.getId());
                    query.put("status",PdWorkOrder.PdWorkOrderStatus.STATUS_START);
                    List<PdWorkOrder> workOrders = this.pdWorkOrderMapper.findByMap(query);
                    List<Node> pdChildrens = Lists.newArrayList();
                    for (PdWorkOrder workOrder : workOrders) {
                        Node workOrderNode = new Node();
                        workOrderNode.setId(workOrder.getId());
                        workOrderNode.setName(workOrder.getWorkOrderNum());
                        workOrderNode.setChildren(null);
                        pdChildrens.add(workOrderNode);
                    }
                    if (null != pdChildrens && pdChildrens.size() > 0) {
                        pdNode.setChildren(pdChildrens);
                    } else {
                        pdNode.setChildren(Lists.newArrayList());
                    }
                    lineChildrens.add(pdNode);
                }
                if (null != lineChildrens && lineChildrens.size() > 0) {
                    pdLineNode.setChildren(lineChildrens);
                } else {
                    pdLineNode.setChildren(Lists.newArrayList());
                }
                result.add(pdLineNode);
            }
        }catch (Exception e){
            log.error("FtyProductionLineProviderImpl loginPdInfo ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<DpProduceProcess> loginProcess(String workOrderId) throws DubboProviderException {
        List<DpProduceProcess> result = Lists.newArrayList();
        try {
            PdWorkOrder workOrder = this.pdWorkOrderMapper.findById(workOrderId);
            Map<String, Object> query = Maps.newHashMap();
            query.put("projectId", workOrder.getProjectId());
            List<DpProduceProcess> produceProcesses = this.dpProduceProcessMapper.findByMap(query);
            for (DpProduceProcess produceProcess : produceProcesses) {
                if (null != produceProcess.getFormId()) {
                    DpProduceProcess process = new DpProduceProcess();
                    process.setId(produceProcess.getId());
                    process.setProcessName(produceProcess.getProcessName());
                    result.add(process);
                }
            }
        }catch (Exception e){
            log.error("FtyProductionLineProviderImpl loginProcess ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 验证分类下是否有数据
     * @param id
     * @return
     * ledengyun--2017/09/22
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException{

        int usage;
        boolean flag = true;
        usage = pdLineMapper.countUsage(id);
        if(usage>0){
            flag = false;
        }
        return flag;
    }
}
