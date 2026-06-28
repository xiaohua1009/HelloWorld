package com.lshaohua.helloworld.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        int sumClosest = threeSumClosest(nums, -2);
        System.out.println(sumClosest);
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int sumClosest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, rihgt = nums.length - 1;
            while (left < rihgt) {
                int sum = nums[i] + nums[left] + nums[rihgt];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(sumClosest - target)) {
                    sumClosest = sum;
                }
                if (sum > target) {
                    rihgt--;
                } else {
                    left++;
                }
            }
        }
        return sumClosest;
    }

}
