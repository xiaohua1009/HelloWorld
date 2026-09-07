package com.lshaohua.helloworld.algorithm;

import java.util.ArrayList;
import java.util.List;

public class _78SubSets {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> subSets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sets = new ArrayList<>();
        backTrace(nums, 0, sets, res);
        return res;
    }

    public static void backTrace(int[] nums, int index, List<Integer> sets, List<List<Integer>> res) {

        res.add(new ArrayList<>(sets));
        for (int i = index; i < nums.length; i++) {
            sets.add(nums[i]);
            backTrace(nums, i + 1, sets, res);
            sets.remove(sets.size() - 1);
        }

    }
}
