package com.lshaohua.helloworld.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class _85MaxRectangle {

    public int maxRectangle(char[][] matrix) {

        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int[] heights = new int[colNum];
        int maxArea = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRetangleArea(heights));
        }
        return maxArea;
    }

    public int largestRetangleArea(int[] heights) {
        int maxArea = 0;
        int len = heights.length;
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            int curHeight = heights[i];
            while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                int topHeight = heights[stack.pop()];
                int curWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, curWidth * topHeight);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
