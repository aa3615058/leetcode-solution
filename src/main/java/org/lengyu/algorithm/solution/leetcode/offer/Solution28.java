package org.lengyu.algorithm.solution.leetcode.offer;

import org.lengyu.algorithm.common.TreeNode;

public class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isImage(root.left, root.right);
    }

    private boolean isImage(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        else if(left != null && right != null) {
            if(left.val == right.val) {
                return isImage(left.right, right.left) && isImage(left.left, right.right);
            }else return false;
        }else return false;
    }

    /*private void dfs(TreeNode root) {
        if(!res)return;
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        dfs(root.left);
        dfs(root.right);
        if(root.left != null && root.right != null) {
            if(root.left.val != root.right.val) res = false;
        }else res = false;
    }*/

    /*private boolean isEqual(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        else if(left != null && right != null) return left.val == right.val && isEqual(left.left, right.left) && isEqual(left.right, right.right);
        else return false;
    }*/
}
