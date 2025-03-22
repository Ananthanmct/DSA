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
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        TreeNode temp = root;
        while(temp != null){
            st.push(temp);
            temp = temp.left;
        }
    }
    
    public int next() {
        TreeNode node = st.pop();
        TreeNode temp = node.right;
        while(temp != null){
            st.push(temp);
            temp = temp.left;
        }
        return node.val;
    }

    
    public boolean hasNext() {
        if(st.size() > 0){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */