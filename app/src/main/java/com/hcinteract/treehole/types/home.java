package com.hcinteract.treehole.types;

public class home {
    public String title;
    public String time;
    public String user;
    public String intro;
    public int agrees;
    public int comments;


    public home(String title, String user, String time, String intro, int agrees, int comments) {
        this.title = title;
        this.time = time;
        this.user = user;
        this.intro = intro;
        this.agrees = agrees;
        this.comments = comments;
    }
}
