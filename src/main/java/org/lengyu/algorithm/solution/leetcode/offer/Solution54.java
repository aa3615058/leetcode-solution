package org.lengyu.algorithm.solution.leetcode.offer;

import org.lengyu.algorithm.common.TreeNode;

public class Solution54 {
    private int target = 0;
    private int count = 0;

    public int kthLargest(TreeNode root, int k) {
        count = 0;
        treeInOrder(root, k);
        return target;
    }

    private void treeInOrder(TreeNode root, int k) {
        if(root == null) return;
        treeInOrder(root.right, k);
        if(count == k) return;
        else {
            target = root.val;
            count++;
        }
        treeInOrder(root.left, k);
    }
}
