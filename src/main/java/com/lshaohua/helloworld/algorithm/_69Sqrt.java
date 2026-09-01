package com.lshaohua.helloworld.algorithm;

public class _69Sqrt {

    public static void main(String[] args) {

    }

    public static int findSqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x/2;
        int res = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
