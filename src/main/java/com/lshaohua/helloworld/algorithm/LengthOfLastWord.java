package com.lshaohua.helloworld.algorithm;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord2("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }

    public static int lengthOfLastWord2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sLen = s.length();
        int worldLen = 0, index = sLen - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        while (index >= 0 && s.charAt(index) != ' ') {
            worldLen++;
            index--;

        }
        return worldLen;
    }
}
