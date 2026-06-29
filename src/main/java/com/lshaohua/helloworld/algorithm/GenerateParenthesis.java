package com.lshaohua.helloworld.algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        backTrace(n, 0, 0, builder, result);
        return result;
    }

    public static void backTrace(int n, int left, int right, StringBuilder builder, List<String> result) {
        if (left == n && right == n) {
            result.add(builder.toString());
            return;
        }
        if (left < n) {
            builder.append("(");
            backTrace(n, left + 1, right, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right < left) {
            builder.append(")");
            backTrace(n, left, right + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
