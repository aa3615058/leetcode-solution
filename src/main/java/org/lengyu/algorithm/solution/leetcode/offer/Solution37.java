package org.lengyu.algorithm.solution.leetcode.offer;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonValue;

import java.util.LinkedList;

import org.lengyu.algorithm.common.TreeNode;

public class Solution37 {
    public class Codec {
       public String serialize(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            StringBuilder s0 = new StringBuilder();
            if(root != null) queue.add(root);

            s0.append('[');
            while(!queue.isEmpty()) {
                int size = queue.size();
                boolean allNull = true;
                for(int i = 0; i < size; i++) {
                    TreeNode t = queue.poll();
                    if(t != null) {
                        s0.append(Integer.toString(t.val));
                        queue.add(t.left);
                        queue.add(t.right);
                        if(allNull && ((t.left!=null||t.right!=null))) allNull=false;
                    }else s0.append("null");
                    if(i==size-1 && allNull) {
                        s0.append(']');
                        return s0.toString();
                    }else s0.append(',');
                }
            }
            s0.append(']');
            return s0.toString();
        }
        
        public TreeNode deserialize(String data) {
            JsonArray ja = Json.parse(data).asArray();
            if(ja.size() == 0 || ja.get(0).isNull()) return null;
            TreeNode root = new TreeNode(ja.get(0).asInt());
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean left = true;
            for(int j = 1; j < ja.size(); j++) {
                JsonValue jv = ja.get(j);
                TreeNode t = null;
                if(!jv.isNull()) {
                    t = new TreeNode(jv.asInt());
                    TreeNode t0 = queue.peek();
                    if(left) t0.left = t;
                    else t0.right = t;
                    queue.add(t);
                }
                if(!left) queue.poll();
                left = !left;
            }
            return root;
        }
    }
}
