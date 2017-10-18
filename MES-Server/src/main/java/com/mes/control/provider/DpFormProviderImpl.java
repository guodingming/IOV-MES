package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.utils.FileUtils;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.DpFormMapper;
import com.mes.control.mapper.DpFormTypeMapper;
import com.mes.control.mapper.PdMapper;
import com.mes.dubbo.interprovider.control.IDpFormProvider;
import com.mes.entity.control.DpForm;
import com.mes.entity.control.DpFormType;
import com.mes.entity.control.Pd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-表单
 */
public class DpFormProviderImpl extends BaseProviderImpl<DpForm> implements IDpFormProvider {
    @Autowired
    @Qualifier("dpFormMapper")
    private DpFormMapper dpFormMapper;
    @Autowired
    @Qualifier("dpFormTypeMapper")
    private DpFormTypeMapper dpFormTypeMapper;

    @Autowired
    @Qualifier("pdMapper")
    private PdMapper pdMapper;

    @Override
    public DpFormMapper getBaseInterfaceMapper() {
        return dpFormMapper;
    }

    @Override
    public List<Node> getFormTypedTree(String pdId) {
        List<Node> nodes = Lists.newArrayList();
        try {
            List<DpFormType> types = Lists.newArrayList();
            if (pdId != null && !pdId.isEmpty()) {
                Map<String, Object> mapQueryType = Maps.newHashMap();
                mapQueryType.put("pdId", pdId);
                types = dpFormTypeMapper.findByMap(mapQueryType);
            } else {
                types = dpFormTypeMapper.findAll();
            }
            if (types != null && !types.isEmpty()) {
                types.stream().forEach(type -> {
                    Node node = new Node();
                    node.setId(type.getId());
                    node.setName(type.getName());
                    List<Node> children = Lists.newArrayList();
                    Map<String, Object> mapQueryForm = Maps.newHashMap();
                    mapQueryForm.put("formTypeId", type.getId());
                    List<DpForm> forms = dpFormMapper.findByMap(mapQueryForm);
                    if (forms != null && !forms.isEmpty()) {
                        forms.stream().forEach(form -> {
                            Node childNode = new Node();
                            childNode.setId(form.getId());
                            childNode.setName(form.getName());
                            childNode.setDescription(form.getDescription());

                            children.add(childNode);
                        });
                    }
                    node.setChildren(children);
                    nodes.add(node);
                });
            }
        } catch (Exception e) {
            log.error("DpFormProviderImpl getFormTypedTree is error :", e);
        }
        return nodes;
    }


    @Override
    public boolean update(DpForm entity) throws DubboProviderException {
        try {
            //保存表单数据到文件
            this.saveToFile(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.update(entity);
    }

    /**
     * 保存数据到文件
     * @param dpForm
     * @throws Exception
     */
    private void saveToFile(DpForm dpForm) throws Exception {
        //保存表单数据到文件
        DpForm form = this.dpFormMapper.findById(dpForm.getId());
        Pd pd = this.pdMapper.findById(form.getPdId());
        if (null != form) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String dateString = formatter.format(date);
            String path = ConfigHelper.getValue("shared.fs.dir");
            File html = new File(path + "/station-form-script/" + pd.getName() + "/" + form.getName() + "/" + dateString + "/" + form.getName() + "_" + form.getId() + ".html");
            File javaScript = new File(path + "/station-form-script/" + pd.getName() + "/" + form.getName() + "/" + dateString + "/" + form.getName() + "_" + form.getId() + ".js");
            File config = new File(path + "/station-form-script/" + pd.getName() + "/" + form.getName() + "/" + dateString + "/" + form.getName() + "_" + form.getId() + ".properties");
            FileUtils.write(dpForm.getHtml(), html);
            FileUtils.write(dpForm.getJavascript(), javaScript);
            FileUtils.write("width=" + dpForm.getWidth() + "\nheight=" + dpForm.getHeight(), config);
        }
    }

    @Override
    public boolean cloneForm(DpForm dpForm) {
        try {
            String ids = dpForm.getFormIds();
            String[] formIds = ids.split(",");
            for (String formId : formIds) {
                DpForm dbForm = this.dpFormMapper.findById(formId);
                if (null != dbForm) {
                    dpForm.setHtml(dbForm.getHtml());
                    dpForm.setJavascript(dbForm.getJavascript());
                    dpForm.setWidth(dbForm.getWidth());
                    dpForm.setHeight(dbForm.getHeight());
                    dpForm.setName(dbForm.getName());
                    dpForm.setId(IDGenerator.getID());
                    super.save(dpForm);
                    this.saveToFile(dpForm);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
