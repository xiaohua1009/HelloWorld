package com.lshaohua.helloworld.algorithm;

public class _100IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        return backTrace(p, q);
    }

    boolean backTrace(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return backTrace(p.left, q.left) && backTrace(p.right, q.right);
    }
}
