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
    TreeNode prev = null;
    TreeNode curr = null;
    TreeNode node1 = null;
    TreeNode node2 = null;
    public void recoverTree(TreeNode root) {
        traversal(root);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    public void traversal(TreeNode root){
        if(root == null){
            return;
        }
        traversal(root.left);
        // Inorder 
        curr = root;

        if(prev != null && prev.val > curr.val){
            // What ?? 
            
            if(node1 == null){
                node1 = prev;
                node2 = curr;
            }else{
                node2 = curr;
            }
        }
    
        prev = curr;
        traversal(root.right);
    }
}
