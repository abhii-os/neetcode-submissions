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
    private int preIndex = 0;
    private Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        map = new HashMap<>();
        
        for(int i =0; i< inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd){
        if(inStart>inEnd) return null;

        int rootVal = preorder[preIndex];
        preIndex++;
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = map.get(rootVal);

        root.left = build(preorder,inStart,rootIndex-1);
        root.right = build(preorder,rootIndex+1,inEnd);
        return root;
    }
}
