package org.lengyu.algorithm.solution.leetcode.offer;

import org.lengyu.algorithm.common.TreeNode;

public class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        dfs(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
