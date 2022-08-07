package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.ArrayList;

public class Solution36 {
    protected ArrayList<Node> list = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        if(root == null) return root;

        list.clear();
        dfs(root);

        Node pre = list.get(list.size()-1);
        for(Node n : list) {
            pre.right = n;
            n.left = pre;
            pre = n;
        }
        return list.get(0);
    }

    private void dfs(Node root) {
        if(root == null) return;
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }

    protected class Node {
        public int val;
        public Node left;
        public Node right;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
