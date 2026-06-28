package com.lshaohua.helloworld.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, rihgt = nums.length - 1;
            while (left < rihgt) {
                int sum = nums[i] + nums[left] + nums[rihgt];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[rihgt]));
                    while (left < rihgt && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < rihgt && nums[rihgt] == nums[rihgt - 1]) {
                        rihgt--;
                    }
                    left++;
                    rihgt--;
                } else if (sum > 0) {
                    rihgt--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

}
