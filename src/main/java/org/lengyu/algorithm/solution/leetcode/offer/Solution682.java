package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.LinkedList;

import org.lengyu.algorithm.common.TreeNode;

public class Solution682 {
    private boolean flag;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> listA = new LinkedList<>();
        LinkedList<TreeNode> listB = new LinkedList<>();

        flag = false;
        dfs(root,p,listA);
        flag = false;
        dfs(root,q,listB);

        TreeNode res = root;
        while(!listA.isEmpty() && !listB.isEmpty()) {
            TreeNode a = listA.pop();
            TreeNode b = listB.pop();
            if(a.val == b.val) res = a;
            else return res;
        }

        return res;
    }

    //在树 root 中 寻找节点 a，并记录遍历路径
    private void dfs(TreeNode root, TreeNode a, LinkedList<TreeNode> list) {
        if(!flag) {
            if(root.val == a.val) flag = true;
            else {
                if(root.left != null) dfs(root.left,a,list);
                if(root.right != null) dfs(root.right,a,list);
            }
            if(flag) list.push(root);
        }
    }
}
