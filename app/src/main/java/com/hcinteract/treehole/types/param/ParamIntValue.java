package com.hcinteract.treehole.types.param;

public class ParamIntValue extends Param {
    public int value;

    public ParamIntValue(String key, int value) {
        super(key);
        this.value = value;
    }
}
