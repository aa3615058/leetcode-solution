package org.lengyu.algorithm.solution.leetcode.offer;

import org.lengyu.algorithm.common.TreeNode;

public class Solution26 {
    private TreeNode rootB;
    private boolean res;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        rootB = B;
        res = false;
        dfs(A);
        return res;
    }

    private void dfs(TreeNode root) {
        if(!res) {
            if(root == null) return;
            if(root.val == rootB.val) res = equal(root,rootB);
            dfs(root.left);
            dfs(root.right);
        }
    }

    //同一个根节点比较是否相同，两节点同进同退
    //由于 B 是子集，允许 B 的某些节点为空，A 不为空的情况
    //除此之外，B 和 A 的节点应该各个相等
    private boolean equal(TreeNode A, TreeNode B) {
        if(A == null && B == null) return true;
        else if(A != null && B == null) return true;
        else if(A != null && B != null && A.val == B.val) {
            return equal(A.left, B.left) && equal(A.right, B.right);
        }
        else return false;
    }
}
