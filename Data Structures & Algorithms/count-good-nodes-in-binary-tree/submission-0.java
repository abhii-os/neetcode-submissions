/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
       return dfs(root,root.val);
    }
    private int dfs(TreeNode node, int max_val){
        if(node == null){
            return 0;
        }
        int count = 0;
        if(node.val >= max_val){
            count = 1;
            max_val = node.val;
        }

        count += dfs(node.left,max_val);
        count += dfs(node.right,max_val);

        return count;

    }
}
