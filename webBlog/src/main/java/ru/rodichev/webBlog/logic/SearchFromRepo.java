package ru.rodichev.webBlog.logic;

public class SearchFromRepo {
    public static String toLike(String str){
        return "%" + str + "%";
    }
}
