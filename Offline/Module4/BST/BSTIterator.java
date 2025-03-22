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
class BSTIteratorApproach1 {
    ArrayList<Integer> inorder;
    int index;
    private void inorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }

    public BSTIterator(TreeNode root) {
        this.index = 0;
        this.inorder = new ArrayList<>(); //O(n)
        inorderTraversal(root);
    }
    
    public int next() {
        // O(1)
        // index = 0
        int val = this.inorder.get(index); // postfix opertaion
        index++;
        return val;
    }
    
    public boolean hasNext() {
        // O(1)
        return this.index < inorder.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */