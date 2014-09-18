package com.github.alxwhtmr.muw.sandbox;

import com.github.alxwhtmr.muw.common.Common;

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
    }
}
