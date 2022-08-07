package org.lengyu.algorithm.solution.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.lengyu.algorithm.common.TreeNode;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;
        else queue.add(root);
        int size = 1;
        int base = size;
        List<Integer> a = new ArrayList<>(base);;
        while(!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if(t != null) {
                a.add(t.val);
                if(t.left!=null)queue.add(t.left);
                if(t.right!=null)queue.add(t.right);
            }
            
            size--;
            if(size == 0) {
                result.add(a);
                a = new ArrayList<>(base);
                size = queue.size();
                base = size;
            }
        }
        return result;
    }
}
