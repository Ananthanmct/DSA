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

    public TreeNode createTree(int [] pre, int [] in, int psi, int pei, int isi, int iei, HashMap<Integer, Integer> map){
        if(psi > pei){
            return null;
        }

        if(isi > iei){
            return null;
        }

        if(psi == pei && isi == iei){
            return new TreeNode(pre[psi]);
        }
        // Create root
        TreeNode root = new TreeNode(pre[psi]);
        // Left and Right Subtree we will define ranges 
        // Left ->
        int idx = map.get(pre[psi]);
        int lc = idx - isi;

        int lisi = isi;
        int liei = idx - 1;
        int lpsi = psi + 1;
        int lpei = psi + lc;

        int risi = idx + 1;
        int riei = iei;
        int rpsi = lpei + 1;
        int rpei = pei;

        root.left = createTree(pre, in, lpsi, lpei, lisi, liei, map);
        root.right = createTree(pre, in, rpsi, rpei, risi, riei, map);
        return root;

    }

    public TreeNode buildTree(int[] pre, int[] in) {
        int n = pre.length; 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++){
            map.put(in[i], i);
        }
        TreeNode root = createTree(pre, in, 0, n - 1, 0, n - 1, map);
        return root;
    }
}
