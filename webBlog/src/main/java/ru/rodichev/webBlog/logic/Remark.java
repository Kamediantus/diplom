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
    public static List<String> getCords(String allRemarks){
        List<String> cords = new ArrayList<>();
        String[] splitRemarks = allRemarks.split("\\|\\|");
        for(int i = 0; i < splitRemarks.length; i ++){
            String[] oneRemark = splitRemarks[i].split("\\|");
            cords.add(oneRemark[2]);
        }
        return cords;
    }

    public static String createPopups(String fulltext, List<String> mistakes, List<String> remarks, List<String> cords){
        int start;
        int end;
        for (int i = remarks.size() - 1; i >= 0; i--){
            start = Integer.parseInt(cords.get(i).split(",")[0]);
            end = Integer.parseInt(cords.get(i).split(",")[1]);
            fulltext = fulltext.substring(0,start) +
                    "<span class=\"popup\" onclick=\"popupFunc(" + i + ")\">" +
                    mistakes.get(i) +
                    "<span class=\"popuptext\" id=\"myPopup" + i + "\">" +
                    remarks.get(i) + "</span></span>" + fulltext.substring(end);
        }
        return fulltext;
    }

}
