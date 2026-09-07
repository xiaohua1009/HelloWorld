package com.lshaohua.helloworld.algorithm;

import java.util.ArrayList;
import java.util.List;

public class _89GrayCode {

    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // 总共有 2^n 个数字，可以用位移运算 1 << n 来表示
        int totalNumbers = 1 << n;

        for (int i = 0; i < totalNumbers; i++) {
            // 核心魔法公式：i 与其自身右移 1 位的结果进行异或
            result.add(i ^ (i >> 1));
        }

        return result;
    }
}
