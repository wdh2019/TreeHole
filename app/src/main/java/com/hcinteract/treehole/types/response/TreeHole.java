package com.hcinteract.treehole.types.response;

public class TreeHole {
    public int treeHoleId; // id
    public String content; // 内容
    public int creator; // 创建人
    public long createTime; // 创建时间


    public TreeHole(int treeHoleId, String content, int creator, long createTime) {
        this.treeHoleId = treeHoleId;
        this.content = content;
        this.creator = creator;
        this.createTime = createTime;
    }
}
