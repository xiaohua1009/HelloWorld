package com.lshaohua.helloworld.algorithm;

public class Regular {
    public static void main(String[] args) {
        System.out.println(regular("aaa", "a*a"));
    }

    public static boolean regular(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int sLen = s.length(), pLen = p.length();
        // dp[i][j] 表示s的前i个字符与p的前j个字符匹配
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        // dp[0][0]表示s=""，p=""，是匹配的
        dp[0][0] = true;
        // 初始化第一行，s=""，p的格式必须为a*b*c*
        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (isMatch(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (isMatch(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }

        }
        return dp[sLen][pLen];
    }

    public static boolean isMatch(String s, String p, int i, int j) {
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
