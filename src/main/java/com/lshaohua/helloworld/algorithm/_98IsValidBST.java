package com.lshaohua.helloworld.algorithm;

public class _98IsValidBST {

    public boolean validBST(TreeNode root) {
        return backTrace(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean backTrace(TreeNode root, long leftLimit, long rightLimit) {
        if (root == null) {
            return true;
        }
        if (root.val > leftLimit && root.val < rightLimit) {
            return backTrace(root.left, leftLimit, root.val) && backTrace(root.right, root.val, rightLimit);
        }
        return false;
    }

}
