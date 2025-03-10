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
    int maxDia = Integer.MIN_VALUE;
    public int hieght(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = hieght(root.left);
        int rh = hieght(root.right);
        maxDia = Math.max(maxDia, lh + rh);
        return Math.max(lh, rh) + 1;
    }
    public int calculateDia(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = hieght(root.left);
        int rh = hieght(root.right);
        int leftDia = calculateDia(root.left);
        int rightDia = calculateDia(root.right);
        int myDia = lh + rh + 2;
        return Math.max(myDia, Math.max(leftDia, rightDia));
    }
    public int diameterOfBinaryTree(TreeNode root) {
       int h = hieght(root);
       return  maxDia;
    }
}