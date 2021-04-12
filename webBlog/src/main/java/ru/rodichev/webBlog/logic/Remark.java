package ru.rodichev.webBlog.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Remark {


    public static List<String> getRemarks(String allRemarks){
        List<String> remarks = new ArrayList<>();
        String[] splitRemarks = allRemarks.split("\\|\\|");
        for(int i = 0; i < splitRemarks.length; i ++){
            String[] oneRemark = splitRemarks[i].split("\\|");
            remarks.add(oneRemark[1]);
        }
        return remarks;
    }

    public static List<String> getMistakes(String allRemarks){
        List<String> mistakes = new ArrayList<>();
        String[] splitRemarks = allRemarks.split("\\|\\|");
        for(int i = 0; i < splitRemarks.length; i ++){
            String[] oneRemark = splitRemarks[i].split("\\|");
            mistakes.add(oneRemark[0]);
        }
        return mistakes;
    }

}
