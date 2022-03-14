package com.company;

import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        //String str = "강한친구 대한육군";
        String str = "무궁화 꽃이 피었습니다.";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        //String encodingLanguage = new;
        String returnValue = new String(bytes);

        Main.checkEncoding(str);

        System.out.println(returnValue);
    }

    public static void checkEncoding(String str) {
        String[] charSet = {"utf-8", "euc-kr", "ksc5601", "iso-8859-1", "x-windows-949"};

        for (int i = 0; i < charSet.length; i++) {
            for (int j = 0; j < charSet.length; j++) {
                try {
                    System.out.println(charSet[i] + ":" + charSet[j] + "=" + new String(str.getBytes(charSet[i]), charSet[j]));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
