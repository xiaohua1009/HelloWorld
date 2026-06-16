package com.lshaohua.helloworld.algorithm;

public class Atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("-21474836482"));
    }

    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        boolean positive  = true;
        int index = 0;
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            positive = s.charAt(index) == '+';
            s = s.substring(1);
        }
        int result = 0;
        while(index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && s.charAt(index) - '0' > Integer.MAX_VALUE % 10)) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                result = result * 10 + (s.charAt(index) - '0');
            }
            index++;
        }
        return positive ? result : -result;
    }

    public static int myAtoi2(String s) {
        int n = s.length();
        int i = 0;
        int sign = 1;
        int res = 0;

        // 1. 丢弃前导空格
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 如果字符串全为空格，直接返回
        if (i == n) {
            return 0;
        }

        // 2. 检查符号
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++; // 读取完符号后，指针向后移动一位
        }

        // 3. 读取数字并转换
        // 提前算出最大值的 1/10，用于防溢出拦截
        int limit = Integer.MAX_VALUE / 10;

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4. 越界预判（和上一题反转整数的逻辑完全一致！）
            // 最大值 2147483647 的个位是 7
            if (res > limit || (res == limit && digit > 7)) {
                // 如果发生了越界，根据符号直接返回对应的极限值
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // 安全拼接数字
            res = res * 10 + digit;
            i++;
        }

        // 加上符号返回
        return res * sign;
    }

}
