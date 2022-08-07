package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;

import org.lengyu.algorithm.common.TreeNode;

public class Solution321 {
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }

        int[] a = new int[list.size()];
        for(int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }

        return a;
    }
}
