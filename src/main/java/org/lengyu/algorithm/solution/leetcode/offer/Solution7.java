package org.lengyu.algorithm.solution.leetcode.offer;

import org.lengyu.algorithm.common.TreeNode;

public class Solution7 {
    private int[] a;
    private int[] b;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        a = preorder;
        b = inorder;
        TreeNode root = new TreeNode(preorder[0]);
        build(root, 0, preorder.length-1, 0, inorder.length-1);
        return root;
    }

    private void build(TreeNode root, int ax, int ay, int bx, int by) {
        int len = ay - ax;
        if(len <= 0) return;
        //search
        int bi = bx;
        for(int i = bx; i <= by; i++) {
            if(b[i] == a[ax]) {
                bi=i;
                break;
            }
        }
        //build left
        if(bi > bx) {
            root.left = new TreeNode(a[ax+1]);
            build(root.left,ax+1,ax+bi-bx,bx,bi-1);
        }
        //build right
        if(bi < by) {
            root.right = new TreeNode(a[ax+bi-bx+1]);
            build(root.right,ax+bi-bx+1,ay,bi+1,by);
        }
    }
}
