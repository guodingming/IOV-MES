package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.framework.rest.view.Page;
import com.mes.control.mapper.FtyAreaMapper;
import com.mes.control.mapper.FtySiteInfoMapper;
import com.mes.dubbo.interprovider.control.IFtySiteInfoProvider;
import com.mes.entity.control.FtyArea;
import com.mes.entity.control.FtySiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

public class FtySiteInfoProviderImpl extends BaseProviderImpl<FtySiteInfo> implements IFtySiteInfoProvider {
    @Autowired
    @Qualifier("ftySiteInfoMapper")
    private FtySiteInfoMapper ftySiteInfoMapper;

    @Autowired
    @Qualifier("ftyAreaMapper")
    private FtyAreaMapper ftyAreaMapper;

    @Override
    public FtySiteInfoMapper getBaseInterfaceMapper() {
        return ftySiteInfoMapper;
    }

    @Override
    public Page getPageByEnterpriseId(Page page) throws DubboProviderException {
        Map<String, Object> params = Maps.newHashMap();
        if (page != null && page.getCondition() != null && Map.class.isInstance(page.getCondition())) {
            params = (Map) page.getCondition();
        }
        return findByPage(page, params);
    }

    @Override
    public List<Node> getSiteAreaTree(String enterpriseId) {
        List<Node> nodes = Lists.newArrayList();

        Map<String, Object> params = Maps.newHashMap();
        params.put("enterpriseId", enterpriseId);
        List<FtySiteInfo> siteInfos = ftySiteInfoMapper.findByMap(params);
        if (siteInfos != null && !siteInfos.isEmpty()) {
            siteInfos.stream().forEach(siteInfo -> {
                Node node = new Node();
                node.setId(siteInfo.getId());
                node.setName(siteInfo.getName());
                node.setParentId(enterpriseId);
                node.setDescription(siteInfo.getDescription());
                node.setData(siteInfo);
                nodes.add(node);

                Map<String, Object> map = Maps.newHashMap();
                map.put("siteInfoId", siteInfo.getId());
                List<FtyArea> areas = ftyAreaMapper.findByMap(map);
                if (areas != null && !areas.isEmpty()) {
                    List<Node> children = Lists.newArrayList();
                    areas.stream().forEach(area -> {
                        Node n = new Node();
                        n.setId(area.getId());
                        n.setName(area.getName());
                        n.setParentId(siteInfo.getId());
                        n.setDescription(area.getDescription());
                        n.setLeaf(true);
                        n.setData(area);
                        children.add(n);
                    });
                    node.setChildren(children);
                }
            });
        }
        return nodes;
    }

    /**
     * 分类删除验证
     * @param id
     * @return
     * lednegyun--2017/10/10
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException{

        int usage;
        boolean flag = true;
        usage =ftySiteInfoMapper.countUsage(id);
        if(usage>0){
            flag = false;
        }
        return flag;

    }
}
