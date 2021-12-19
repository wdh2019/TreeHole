package com.hcinteract.treehole.types.response;

public class Reply {
    public int replyId; // 回复的 id
    public int treeHoleId; // 所属 treeHole 的 id
    public int reReplyId; // 回复哪一条帖子的 id
    public String replier; // 发回复的人的 username
    public String content; // 回复的具体内容
    public long replyTime; // 回复的时间，从 1970 年 1 月 1 日起的毫秒数，如 1639893920841

    public Reply(int replyId, int treeHoleId, int reReplyId, String replier, String content, long replyTime) {
        this.replyId = replyId;
        this.treeHoleId = treeHoleId;
        this.reReplyId = reReplyId;
        this.replier = replier;
        this.content = content;
        this.replyTime = replyTime;
    }
}
