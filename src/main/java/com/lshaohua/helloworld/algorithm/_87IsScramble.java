package com.lshaohua.helloworld.algorithm;

import java.util.HashMap;
import java.util.Map;

public class _87IsScramble {
    public static void main(String[] args) {
        System.out.println(isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
    }

    private static Map<String ,Boolean> meno = new HashMap<>();

    public static boolean isScramble(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        if (s.equals(t)){
            return true;
        }
        if (sLen == 1) {
            return false;
        }

        String key = s + "_" + t;

        if (meno.containsKey(key)) {
            return meno.get(key);
        }

        if (!hasSameChars(s, t)){
            meno.put(key, false);
            return false;
        }

        for (int i = 1; i < sLen; i++) {
            if (isScramble(s.substring(0,i), t.substring(0,i))
                    && isScramble(s.substring(i),t.substring(i))) {
                meno.put(key, true);
                return true;
            }
            if (isScramble(s.substring(0,i), t.substring(tLen - i)) && isScramble(s.substring(i), t.substring(0, tLen - i))) {
                meno.put(key, true);
                return true;
            }
        }
        meno.put(key, false);
        return false;
    }
    
    private static boolean hasSameChars(String str1, String str2) {
        int[] charNum = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            charNum[str1.charAt(i) - 'a']++;
            charNum[str2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (charNum[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
