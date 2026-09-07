package com.lshaohua.helloworld.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class _84LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int n = heights.length;
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            int curHeight = (i == n) ? 0 :heights[i];
            while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                int topHeight = heights[stack.pop()];
                int curWidth = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, curWidth * topHeight);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
