package com.lshaohua.helloworld.algorithm;

public class _70ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        int[] meno = new int[n + 1];
        return backTrace(meno, n);
    }

    public static int backTrace(int[] meno, int n) {
        if (n <= 2) {
            return n;
        }

        if (meno[n] != 0) {
            return meno[n];
        }
        meno[n] = backTrace(meno, n - 1) + backTrace(meno, n - 2);
        return meno[n];
    }

}
