package ru.rodichev.webBlog.logic;

import java.util.Arrays;
import java.util.List;

/***
 *  auxiliary class
 */
public class SearchFromRepo {
    /***
     * add '%' before and after str from param to search in DB
     * @param str raw substring
     * @return '%str%'
     */
    public static String toLike(String str) {
        return "%" + str + "%";
    }

    /***
     * parse String of tags to List of tags
     * @param tags raw String
     * @return List of tags as String
     */
    public static List<String> parseTagsAsList(String tags) {
        return Arrays.asList(tags.split(",").clone());
    }
}
