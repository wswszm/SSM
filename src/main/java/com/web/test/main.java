package com.web.test;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/11/2
 */
public class main {
    public static void main(String[] args) {
        String a = "a.abc";
        String ext = a.substring(a.lastIndexOf("."));
        System.out.println(ext);
    }
}
