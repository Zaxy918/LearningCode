package com;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        helloWorld();
    }

    public static void helloWorld() {
        Locale mylocale = Locale.getDefault();
        System.out.println(mylocale);
        ResourceBundle bundle = ResourceBundle.getBundle("msg", mylocale);
        String hello = bundle.getString("hello");
        System.out.println(hello);
        mylocale = new Locale("zh", "CN");
        bundle = ResourceBundle.getBundle("msg", mylocale);
        /*
         * The order of resource file lookup is as follows: msg_zh_CN.properties(one which is the parameter of Locale) msg_zh.properties msg_en_US.properties(default) msg_en.properties msg.properties
         */
        hello = bundle.getString("hello");
        System.out.println(hello);
    }
}