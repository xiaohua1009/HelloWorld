package com.lshaohua.helloworld.algorithm;

import java.util.Arrays;

public class _91NumDecoding {

    public int numDecoding(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return backTrace(s, 0, memo);
    }

    private int backTrace(String s, int index, int[] memo) {
        if (index >= s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }

        int oneChar = backTrace(s, index + 1, memo);
        int twoChar = 0;
        if (index + 1 < s.length()) {
            int twoCharToNum = (s.charAt(index) - '0') * 10 + (s.charAt(index + 1) -  '0');
            if (twoCharToNum <= 26) {
                twoChar = backTrace(s, index + 2, memo);
            }
        }
        int result = oneChar + twoChar;
        memo[index] = result;
        return  result;
    }
}
