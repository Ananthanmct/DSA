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
    public TreeNode find(TreeNode root, int key){
        if(root == null){
            return null;
        }
        if(root.val == key){
            return root;
        }
        if(root.val < key){
            TreeNode node = find(root.right, key);
            return node;
        }else{
            TreeNode node = find(root.left, key);
            return node;
        }
    }
    public TreeNode findMaxNode(TreeNode root){
        if(root.left == null){
            return root;
        }
        
        TreeNode temp = root.left;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }

    public TreeNode delete(TreeNode node, int key){
        if(node == null){
            return null;
        }
        
        if(node.val == key){
            if(node.left != null && node.right != null){
                return null;
            }else if (node.left != null){
                return node.left;
            }else{
                return node.right;
            }
        }
        if(node.val > key){
            node.left = delete(node.left, key);
        }else{
            node.right = delete(node.right, key);
        }
        return node;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        
        TreeNode keyNode = find(root, key);
        if(keyNode == null){
            return root;
        }
        if(keyNode.left == null){
            root = delete(root, key);
            return root;
        }
        TreeNode maxNode = findMaxNode(keyNode);
        int temp = keyNode.val;
        keyNode.val = maxNode.val;
        maxNode.val = temp;
        
        keyNode.left = delete(keyNode.left, key);
        return root;
    }
}
