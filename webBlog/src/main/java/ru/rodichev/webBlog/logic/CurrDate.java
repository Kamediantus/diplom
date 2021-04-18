package ru.rodichev.webBlog.logic;

import java.util.Date;

public class CurrDate {

    /***
     * get current date in format DD MMM YYYY
     * @return  current date in format DD MMM YYYY
     */
    public static String getCurrDate() {
        Date date = new Date();
        return date.toString().substring(8, 11) + date.toString().substring(4, 7) + date.toString().substring(23, 28);
    }
}
