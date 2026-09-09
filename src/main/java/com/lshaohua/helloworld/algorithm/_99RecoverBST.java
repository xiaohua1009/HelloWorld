package com.lshaohua.helloworld.algorithm;

public class _99RecoverBST {

    TreeNode pre = null;
    TreeNode first = null;
    TreeNode secode = null;
    public void recoverBST(TreeNode root) {
        TreeNode cur = root;

        backTrace(cur);
        if (first != null && secode != null) {
            int tmp = first.val;
            first.val = secode.val;
            secode.val = tmp;
        }

    }

    public void backTrace(TreeNode cur) {
        if (cur == null) {
            return;
        }
        backTrace(cur.left);
        if (pre!= null && cur.val < pre.val) {
            if (first == null) {
                first = pre;
            }
            secode = cur;
        }
        pre = cur;
        backTrace(cur.right);
    }
}
