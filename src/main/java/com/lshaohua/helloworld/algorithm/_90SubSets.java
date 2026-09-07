package com.lshaohua.helloworld.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90SubSets {

    public static List<List<Integer>> subSetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrace(nums, 0, res, path);
        return res;
    }

    public static void backTrace(int[] nums, int start, List<List<Integer>> res, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backTrace(nums, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }
}
