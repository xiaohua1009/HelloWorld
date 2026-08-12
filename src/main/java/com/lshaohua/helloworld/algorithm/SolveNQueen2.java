package com.lshaohua.helloworld.algorithm;

import java.util.List;

public class SolveNQueen2 {

    public static void main(String[] args) {
        System.out.println(solveNQueen(2));;
    }

    private static int resultCount = 0;

    public static int solveNQueen(int n) {

        if (n == 0) {
            return resultCount;
        }

        boolean[] column = new boolean[n];
        boolean[] lrDiagonal = new boolean[2*n];
        boolean[] rlDiagonal = new boolean[2*n];
        backTrace(column, lrDiagonal, rlDiagonal, 0, n);
        return resultCount;
    }
    private static void backTrace(boolean[] column, boolean[] lrDiagonal, boolean[] rlDiagonal, int row, int n) {
        if (row == n) {
            resultCount++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (column[i] || lrDiagonal[row - i + n] || rlDiagonal[row + i]) {
                continue;
            }
            column[i] = true;
            lrDiagonal[row - i + n] = true;
            rlDiagonal[row + i] = true;
            backTrace(column, lrDiagonal, rlDiagonal, row + 1, n);
            column[i] = false;
            lrDiagonal[row - i + n] = false;
            rlDiagonal[row + i] = false;
        }

    }

}
