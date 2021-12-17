package com.hcinteract.treehole.types;

public class Post {
    public int posterId;
    public String content;
    public int rePostId;
    public long postTime;

    public Post(int posterId, String content, int rePostId, long postTime) {
        this.posterId = posterId;
        this.content = content;
        this.rePostId = rePostId;
        this.postTime = postTime;
    }
}
