package com.lshaohua.helloworld.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums,0, target, 4);
    }

    public static List<List<Integer>> kSum(int[] nums, int index, long target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < k) {
            return result;
        }

        if (k == 2) {
            return twoSum(nums, index, target);
        }

        for (int i = index; i < nums.length - k + 1; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> sub = kSum(nums, i + 1, target - nums[i], k - 1);
            for (List<Integer> list : sub) {
                list.add(0, nums[i]);
                result.add(list);
            }
        }
        return result;
    }

    public static List<List<Integer>> twoSum(int[] nums, int index, long target) {
        List<List<Integer>> result = new ArrayList<>();
        int left = index, right = nums.length - 1;
        while (left < right) {
            long sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);
                while (left < right && nums[left] == nums[left + 1])
                    left++;
                while (left < right && nums[right] == nums[right - 1])
                    right--;
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }

        }
        return result;
    }
}
