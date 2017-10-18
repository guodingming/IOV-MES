package com.mes.entity.control;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xiuyou.xu on 2017/8/7.
 */
public class JavaMethod implements Serializable {
    private String modifier;
    private String returnType;
    private String name;
    private List<String> paramTypes;

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(List<String> paramTypes) {
        this.paramTypes = paramTypes;
    }
}
