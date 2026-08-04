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
    private int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        sum = Integer.MIN_VALUE;
        calculateSum(root);
        return sum;
    }
    private int calculateSum(TreeNode node){
        if(node==null) return 0;
        int pathSum = 0;

        int leftGain = Math.max(0,calculateSum(node.left));
        int rightGain = Math.max(0,calculateSum(node.right));

        pathSum = node.val + leftGain + rightGain;

        sum = Math.max(sum, pathSum);
        return node.val+ Math.max(leftGain,rightGain);
    }
}
