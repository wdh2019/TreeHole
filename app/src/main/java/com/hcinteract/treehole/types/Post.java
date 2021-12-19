package com.hcinteract.treehole.types;

import com.hcinteract.treehole.types.response.Reply;

public class Post extends Reply {

    public Post(int replyId, int treeHoleId, int reReplyId, String replier, String content, long replyTime) {
        super(replyId, treeHoleId, reReplyId, replier, content, replyTime);
    }
}
