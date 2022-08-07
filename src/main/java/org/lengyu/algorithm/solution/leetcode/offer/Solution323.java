package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.lengyu.algorithm.Answer;
import org.lengyu.algorithm.common.TreeNode;

public class Solution323 {
    @Answer
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean f_left = true;
        while(!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(f_left) list.add(node.val);
                else list.addFirst(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            results.add(list);
            f_left=!f_left;
        }

        return results;
    }

    //这里是将队列作为双端队列，根据打印顺序操作节点的插入顺序。可以改进为操作结果列表，更容易。
    public List<List<Integer>> levelOrderB(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean f_left = true;

        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = f_left ? queue.poll(): queue.pollLast();
                list.add(node.val);
                if(f_left) {
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }else {
                    if(node.right != null) queue.addFirst(node.right);
                    if(node.left != null) queue.addFirst(node.left);
                }
            }
            results.add(list);
            f_left = !f_left;
        }

        return results;
    }
}
