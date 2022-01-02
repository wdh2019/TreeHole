package com.hcinteract.treehole.types;

public class home {
    public int treeHoleId;
    public String content;
    public String creator;
    public long createTime;


    public home(int  treeHoleId, String content, String creator, long createTime) {
        this.treeHoleId = treeHoleId;
        this.content = content;
        this.creator = creator;
        this.createTime = createTime;
    }
}
