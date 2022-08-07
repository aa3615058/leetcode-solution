package org.lengyu.algorithm.solution.leetcode.offer;

import org.lengyu.algorithm.Answer;
import org.lengyu.algorithm.common.TreeNode;

public class Solution681 {
    //递归
    public TreeNode lowestCommonAncestorB(TreeNode root, TreeNode p, TreeNode q) {
        if((p.val < root.val) ^ (q.val < root.val)) return root;
        if(p == root || q == root) return root;
        if(p.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }
    
    @Answer
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode t = root;
        
        while(t!=null) {
            int fp = p.val - t.val;
            int fq = q.val - t.val;
            if(((fp < 0) ^ (fq < 0)) || fp == 0 || fq == 0) return t;
            else {
                if(fp < 0) t = t.left;
                else t = t.right;
            }
        }

        return t;
    }
}
