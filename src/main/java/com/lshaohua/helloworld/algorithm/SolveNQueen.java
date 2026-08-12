package com.lshaohua.helloworld.algorithm;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueen {

    public static void main(String[] args) {
        System.out.println(solveNQueen(5));;
    }

    public static List<List<String>> solveNQueen(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        int[] queenIndex = new int[n];
        boolean[] column = new boolean[n];
        boolean[] lrDiagonal = new boolean[2*n];
        boolean[] rlDiagonal = new boolean[2*n];
        backTrace(result, queenIndex, column, lrDiagonal, rlDiagonal, 0, n);
        return result;
    }

    private static void backTrace(List<List<String>> result, int[] queenIndex, boolean[] column, boolean[] lrDiagonal, boolean[] rlDiagonal, int row, int n) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == queenIndex[i]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (column[i] || lrDiagonal[row - i + n] || rlDiagonal[row + i]) {
                continue;
            }
            queenIndex[row] = i;
            column[i] = true;
            lrDiagonal[row - i + n] = true;
            rlDiagonal[row + i] = true;
            backTrace(result, queenIndex, column, lrDiagonal, rlDiagonal, row + 1, n);
            column[i] = false;
            lrDiagonal[row - i + n] = false;
            rlDiagonal[row + i] = false;
        }
    }


}
