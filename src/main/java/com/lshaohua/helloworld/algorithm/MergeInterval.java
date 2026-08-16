package com.lshaohua.helloworld.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {
        int[][] result = mergeInterval(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }

    public static int[][] mergeInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][2];
        }

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b)-> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            int[] interal = intervals[i];
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interal[0]) {
                result.add(interal);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interal[1]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
