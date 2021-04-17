package ru.rodichev.webBlog.logic;

import java.util.Arrays;
import java.util.List;

public class SearchFromRepo {
    public static String toLike(String str) {
        return "%" + str + "%";
    }

    public static List<String> parseTagsAsList(String tags) {
        return Arrays.asList(tags.split(",").clone());
    }
}
