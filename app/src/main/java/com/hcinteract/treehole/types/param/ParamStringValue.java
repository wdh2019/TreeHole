package com.hcinteract.treehole.types.param;

public class ParamStringValue extends Param{
    public String value;

    public ParamStringValue(String key, String value) {
        super(key);
        this.value = value;
    }
}
