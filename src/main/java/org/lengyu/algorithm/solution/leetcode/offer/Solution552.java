package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.LinkedList;

import org.lengyu.algorithm.Answer;
import org.lengyu.algorithm.common.TreeNode;

public class Solution552 {
    //前序遍历 + DFS 获取深度
    public boolean isBalancedB(TreeNode root) {
        if(root == null) return true;
        return Math.abs(getHeight(root.left)-getHeight(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    
    //后序遍历 + 剪枝
    @Answer
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return getHeightB(root) != -1;
    }

    private int getHeightB(TreeNode root) {
        if(root == null) return 0;
        int left = getHeightB(root.left);
        if(left == -1) return -1;
        int right = getHeightB(root.right);
        if(right == -1) return -1;
        if(Math.abs(left-right)>1)return -1;
        else return 1+Math.max(left,right);
    }

    //层序遍历 + DFS 获取深度
    public boolean isBalancedC(TreeNode root) {
        if(root == null) return true;
        
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(Math.abs(getHeight(node.left)-getHeight(node.right))>1)return false;
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
        }
        return true;
    }

    private int getHeight(TreeNode root) {
        if(root == null) return 0;
        else return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}
