package com.lshaohua.helloworld.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LetterCombine {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static String[] digits2Str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return null;
        }
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        backTrace(digits, 0, builder, result);
        return result;
    }

    private static void backTrace(String digits, int index, StringBuilder builder, List<String> result) {
        if (index == digits.length()) {
            result.add(builder.toString());
            return;
        }
        String str = digits2Str[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));
            backTrace(digits, index + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
