package com.lshaohua.helloworld.algorithm;

import io.micrometer.common.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubString {

    public static void main(String[] args) {
        String str = "abcabcbb";
        // System.out.println("str.indexOf('b') = " + str.indexOf('b'));
        System.out.println(lengthOfLongestSubString(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n ) {
            while(j < n) {
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                } else {
                    break;
                }
            }
            ans = Math.max(ans, j-i);
            set.clear();
            i++;
            j=i;
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int[] chars = new int[128];
        for(int i = 0; i < 128; i++) {
            chars[i] = -1;
        }
        int left = 0, right = 0, length = 0;
        while (left < s.length() && right < s.length()) {
            char c = s.charAt(right);
            if (chars[c] == -1) {
                chars[c] = right;
            } else {
                length = Math.max(right - left, length);
                left = chars[c] >= left ? chars[c] + 1 : left;
                chars[c] = right;
            }
            right++;
        }
        return Math.max(right - left, length);
    }


    // 提交不通过
    public static int lengthOfLongestSubstring3(String s) {
        if (StringUtils.isEmpty(s)) {
            return 0;
        }
        int[] chars = new int[128];
        for(int i = 0; i < 128; i++) {
            chars[i] = -1;
        }
        int left = 0, right = 0, length = 0;
        while (left < s.length() && right < s.length()) {
            char c = s.charAt(right);
            if (chars[c] == -1) {
                chars[c] = right;
            } else {
                left = chars[c];
                length = Math.max(right - left, length);
                chars[c] = right;
            }
            right++;
        }
        if (chars[s.charAt(right - 1)] == -1) {
            return Math.max(right - left - 1, length);
        } else {
            return Math.max(right - chars[s.charAt(right - 1)], length);
        }
    }

    public static int lengthOfLongestSubString(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        Map<Character, Integer> char2Index = new HashMap<>();
        int start = 0, tail = 1, longest = 1;
        char2Index.put(s.charAt(0), 0);
        while (tail < s.length() && start < tail) {
            if (char2Index.containsKey(s.charAt(tail)) && char2Index.get(s.charAt(tail)) >= start) {
                longest = Math.max(longest, tail - start);
                start = char2Index.get(s.charAt(tail)) + 1;
            }
            char2Index.put(s.charAt(tail), tail);
            tail++;
        }
        return Math.max(longest, tail - start);
    }

}
