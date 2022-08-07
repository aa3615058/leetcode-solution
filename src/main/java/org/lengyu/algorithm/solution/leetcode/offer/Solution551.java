package org.lengyu.algorithm.solution.leetcode.offer;
import java.util.LinkedList;

import org.lengyu.algorithm.Answer;
import org.lengyu.algorithm.common.TreeNode;

public class Solution551 {
    //DFS
    @Answer
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        else return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    //BFS
    public int maxDepthB(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        int count=0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if(t.left != null) queue.add(t.left);
                if(t.right != null) queue.add(t.right);
            }
            count++;
        }
        return count;
    }
}
