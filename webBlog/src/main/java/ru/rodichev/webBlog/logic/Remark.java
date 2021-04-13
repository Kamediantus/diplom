package ru.rodichev.webBlog.logic;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class Remark implements Comparable<Remark>{

    private String mistake;
    private String remark;
    private int[] cords = new int[2];
    private String popupView;

    public Remark(String rawRemark){
        String[] elements = rawRemark.split("\\|");
        this.mistake = elements[0];
        this.remark = elements[1];
        this.cords[0] = Integer.parseInt(elements[2].split(",")[0]);
        this.cords[1] = Integer.parseInt(elements[2].split(",")[1]);
    }


    public static String getPopupText(String fullText, List<Remark> remarksList){
        List<Integer> startCords = Remark.getStartCords(remarksList);
        List<Integer> endCords = Remark.getEndCords(remarksList);
        String popupText = fullText;
        for (int i = remarksList.size() - 1; i >= 0 ; i--){
            popupText = popupText.substring(0, startCords.get(i)) +
                    "<span class=\"popup\" onclick=\"popupFunc(" + i + ")\">" +
                    remarksList.get(i).getMistake() + "<span class=\"popuptext\" id=\"myPopup" + i +
                    "\">" + remarksList.get(i).getRemark() + "</span></span>" + popupText.substring(endCords.get(i));
        }
        return popupText;
    }

    public static List<Integer> getStartCords(List<Remark> remarkList){
        List<Integer> endCords = new ArrayList<>();
        for (int i = 0; i < remarkList.size(); i++){
            endCords.add(remarkList.get(i).getFirstCord());
        }
        return endCords;
    }

    public static List<Integer> getEndCords(List<Remark> remarkList){
        List<Integer> endCords = new ArrayList<>();
        for (int i = 0; i < remarkList.size(); i++){
            endCords.add(remarkList.get(i).getLastCord());
        }
        return endCords;
    }

    public static List<Remark> getSortRemarks(String moderatorsText){
        TreeSet<Remark> remarks = new TreeSet<>();
        String[] rawRemarks = moderatorsText.split("\\|\\|");
        for (int i = 0; i < rawRemarks.length; i ++){
            Remark remark = new Remark(rawRemarks[i]);
            remarks.add(remark);
        }
        List<Remark> remarkList = new ArrayList<>();
        for (Remark el : remarks){
            remarkList.add(el);
        }
        return remarkList;
    }



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
//
//    public static String createPopups(String fulltext, List<String> mistakes, List<String> remarks, List<String> cords){
//        int start;
//        int end;
//        for (int i = remarks.size() - 1; i >= 0; i--){
//            String mistake;
//            if (mistakes.get(i).contains("\n")){
//                mistake = mistakes.get(i).replace("\n", " ");
//            } else mistake = mistakes.get(i);
//
////            String mistake = mistakes.get(i).replace("\n", " ");
//            start = Integer.parseInt(cords.get(i).split(",")[0]);
//            end = Integer.parseInt(cords.get(i).split(",")[1]);
//            fulltext = fulltext.substring(0,start) +
//                    "<span class=\"popup\" onclick=\"popupFunc(" + i + ")\">" +
//                    mistake +
//                    "<span class=\"popuptext\" id=\"myPopup" + i + "\">" +
//                    remarks.get(i) + "</span></span>" + fulltext.substring(end);
//        }
//        return fulltext;
//    }


    public int getFirstCord(){
        return this.getCords()[0];
    }

    public int getLastCord(){
        return this.getCords()[1];
    }

    public String getMistake() {
        return mistake;
    }

    public void setMistake(String mistake) {
        this.mistake = mistake;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int[] getCords() {
        return cords;
    }

    public void setCords(int[] cords) {
        this.cords = cords;
    }

    public String getPopupView() {
        return popupView;
    }

    public void setPopupView(String popupView) {
        this.popupView = popupView;
    }

    @Override
    public int compareTo(Remark o) {
        return this.getFirstCord() - o.getFirstCord();
    }
}
