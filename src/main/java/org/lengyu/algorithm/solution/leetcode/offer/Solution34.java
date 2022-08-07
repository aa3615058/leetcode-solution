package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.lengyu.algorithm.common.TreeNode;

public class Solution34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> paths = new ArrayList<>();
        if(root == null) return paths;
        if(root.left == null && root.right == null) {
            if(root.val == target) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(root.val);
                paths.add(list);
                return paths;
            } else return paths;
        }

        List<List<Integer>> left_paths = pathSum(root.left, target-root.val);
        List<List<Integer>> right_paths = pathSum(root.right, target-root.val);
        for(List<Integer> list : left_paths) {
            ((LinkedList<Integer>)list).addFirst(root.val);
            paths.add(list);
        }
        for(List<Integer> list : right_paths) {
            ((LinkedList<Integer>)list).addFirst(root.val);
            paths.add(list);
        }

        return paths;
    }
}
