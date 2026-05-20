package com.lshaohua.helloworld.algorithm;

public class ZConvert {

    public static void main(String[] args) {
        System.out.println(zconvert("PAYPALISHIRING", 4));
    }

    public static String zconvert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        boolean down = false;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            builders[row].append(s.charAt(i));
            if (row == 0 || row == numRows - 1) {
                down = !down;
            }
            if (down) {
                row++;
            } else {
                row--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(builders[i]);
        }
        return result.toString();
    }
}
