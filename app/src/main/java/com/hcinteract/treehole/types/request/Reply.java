package com.hcinteract.treehole.types.request;

public class Reply {
    public int treeHoleId; // 所属 treehole 的 id
    public String content; // 回复的内容
    public int rePostId; // 要回复的帖子的 id

    public Reply(int treeHoleId, String content, int rePostId) {
        this.treeHoleId = treeHoleId;
        this.content = content;
        this.rePostId = rePostId;
    }
}
