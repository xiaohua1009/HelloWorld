package com.lshaohua.helloworld.algorithm;

import java.util.ArrayList;
import java.util.List;

public class _77Combine {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> backTrace(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrace(n, k, 1, path, result);
        return result;
    }

    private static void backTrace(int n, int k, int index, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
        }

        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTrace(n, k, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
