package com.lshaohua.helloworld.algorithm;

public class _88Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mTail = m - 1;
        int nTail = n - 1;
        int mergeTail = nums1.length - 1;
        while (mTail >= 0 && nTail >= 0) {
            if (nums1[mTail] > nums2[nTail]) {
                nums1[mergeTail--] = nums1[mTail--];
            } else {
                nums1[mergeTail--] = nums2[nTail--];
            }
        }
        while (nTail >= 0) {
            nums1[mergeTail--] = nums2[nTail--];
        }
    }
}
