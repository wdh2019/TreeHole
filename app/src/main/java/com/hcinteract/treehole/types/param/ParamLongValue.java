package com.hcinteract.treehole.types.param;

public class ParamLongValue extends Param {
    public long value;

    public ParamLongValue(String key, long value) {
        super(key);
        this.value = value;
    }
}
