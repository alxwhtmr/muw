package com.github.alxwhtmr.muw.sandbox;

import com.github.alxwhtmr.muw.common.Common;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map;

/**
 * Created by alexbel on 16.09.2014.
 */
public class Sandbox {
    public static void main(String[] args) {
        String cmd = "#clear";
        cmd = cmd.substring(1);
        System.out.println(cmd);
        String pattern = Common.Patterns.Service.QUIT_PATTERN;
        System.out.println(cmd.matches(pattern));

        ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
        ArrayList<String> inner = new ArrayList<String>();
//        inner.add("username", "")
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Alex");
//        array.add()
    }
}
