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

public class Codec {

    // Encodes a tree to a single string.
    private static final String nl = "N";
    private static final String dl = ",";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();

    }
    private void buildString(TreeNode node, StringBuilder sb){
        if(node==null){
            sb.append(nl).append(dl);
            return;
        }
        sb.append(node.val).append(dl);
        buildString(node.left,sb);
        buildString(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if((data==null)||data.isEmpty()){
            return null;
        }
        String[] tokens = data.split(dl);
        Queue<String> queue = new LinkedList<>(Arrays.asList(tokens));
        return buildTree(queue);
    }
    private TreeNode buildTree(Queue<String> queue){
        if(queue.isEmpty()){
            return null;
        }
        String val = queue.poll();
        if(val.equals(nl)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left=buildTree(queue);
        root.right = buildTree(queue);

        return root;
    }
}
