package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.lengyu.algorithm.common.TreeNode;

public class Solution322 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            results.add(list);
        }

        return results;
    }
}
