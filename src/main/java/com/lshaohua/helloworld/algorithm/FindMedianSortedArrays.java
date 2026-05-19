package com.lshaohua.helloworld.algorithm;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{-10, -9, -8}, new int[]{}));;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            int num1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int num2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int num1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int num2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];
            if (num1LeftMax <= num2RightMin && num2LeftMax <= num1RightMin) {
                if ((m + n) % 2 == 1) {
                    return Math.max(num1LeftMax, num2LeftMax);
                } else {
                    return (Math.max(num1LeftMax, num2LeftMax) + Math.min(num1RightMin, num2RightMin)) / 2.0;
                }
            } else if (num1LeftMax <= num2RightMin){
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        throw new IllegalArgumentException("数据不合法");
    }
}
