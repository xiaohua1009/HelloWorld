package com.lshaohua.helloworld.algorithm;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        int reverseNum = 0;
        while (x != 0) {
            int remainder = x % 10;
            x /= 10;
            if (reverseNum > Integer.MAX_VALUE / 10 || (reverseNum == Integer.MAX_VALUE / 10 && remainder > 7))
                return 0;

            if (reverseNum < Integer.MIN_VALUE / 10 || (reverseNum == Integer.MIN_VALUE / 10 && remainder < -8))
                return 0;
            reverseNum = reverseNum * 10 + remainder;
        }
        return reverseNum;
    }
}
