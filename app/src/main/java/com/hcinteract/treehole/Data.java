package com.hcinteract.treehole;

import com.hcinteract.treehole.types.home;

import java.util.ArrayList;

public class Data {
    private static ArrayList<home> homeList = new ArrayList<home>();
    private static String searchId = "";
    private static boolean isInit = false;

    //判断数据列表是否初始化
    public static boolean getIsInit(){
        return isInit;
    }

    public static void finishInit(){
        isInit = true;
    }

    public static void setSearchId(String str){
        searchId = str;
    }

    public static ArrayList<home> getHomeList(){
        return homeList;
    }

    public static int getHomeListSize(){
        return homeList.size();
    }

    public static void addHomeList(home newhome){
        homeList.add(newhome);
    }

    // 根据ID来搜索内容
    public static ArrayList<home> getHomeListById(){
        ArrayList<home> temp = new ArrayList<home>();

        for(int i = 0;i < homeList.size(); i ++){
            if(homeList.get(i).treeHoleId == Integer.parseInt(searchId)){
                temp.add(homeList.get(i));
            }
        }

        return temp;
    }

}
