package com.lshaohua.helloworld.algorithm;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
    public static int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int result = 0;
        for (int i = 0; i < romans.length; i++) {
            while (s.startsWith(romans[i])) {
                result += values[i];
                s = s.substring(romans[i].length());
            }
        }
        return result;
    }
}
