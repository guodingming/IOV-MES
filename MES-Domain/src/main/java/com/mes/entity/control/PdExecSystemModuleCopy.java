package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
* $table.description
*
* Created by xiuyou.xu on 2017/09/01.
*/
@ApiModel(value = "PdExecSystemModuleCopy", description = "$table.description")
@XmlAccessorType(XmlAccessType.FIELD)
public class PdExecSystemModuleCopy extends TrackableEntity {
    
    
    @ApiModelProperty(value="$column.description")
    private String systemId;
            
    
    @ApiModelProperty(value="$column.description")
    private String moduleId;
            
    
    @ApiModelProperty(value="$column.description")
    private String subModuleId;
            
    
    @ApiModelProperty(value="$column.description")
    private String systemName;
        
        
    public String getSystemId () {
        return systemId;
    }

    public void setSystemId (String systemId) {
        this.systemId = systemId;
    }
            
    public String getModuleId () {
        return moduleId;
    }

    public void setModuleId (String moduleId) {
        this.moduleId = moduleId;
    }
            
    public String getSubModuleId () {
        return subModuleId;
    }

    public void setSubModuleId (String subModuleId) {
        this.subModuleId = subModuleId;
    }
            
    public String getSystemName () {
        return systemName;
    }

    public void setSystemName (String systemName) {
        this.systemName = systemName;
    }
        
}
