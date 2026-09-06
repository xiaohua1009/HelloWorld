package com.lshaohua.helloworld.algorithm;

public class _76MinWindow {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[] charCount = new int[128];
        for (int i = 0; i < tLen; i++) {
            charCount[t.charAt(i)]++;
        }
        int unMatchCount = tLen;
        int minWindowLen = Integer.MAX_VALUE;
        int minWindowStart = 0;
        int left = 0, right = 0;
        while (right < sLen) {
            char curChar = s.charAt(right);
            if (charCount[curChar] > 0) {
                unMatchCount--;
            }
            charCount[curChar]--;
            while (unMatchCount == 0) {
                int curWindowLen = right - left + 1;
                if (curWindowLen < minWindowLen) {
                    minWindowLen = curWindowLen;
                    minWindowStart = left;
                }
                charCount[s.charAt(left)]++;
                if (charCount[s.charAt(left)] > 0) {
                    unMatchCount++;
                }
                left++;
            }
            right++;
        }
        return minWindowLen == Integer.MAX_VALUE ? "" : s.substring(minWindowStart, minWindowStart + minWindowLen);
    }
}
