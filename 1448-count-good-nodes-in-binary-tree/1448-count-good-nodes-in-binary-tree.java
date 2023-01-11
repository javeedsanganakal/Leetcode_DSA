
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
    int goodNodes;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;  
        int max = Integer.MIN_VALUE;
        goodNodes  = 0;
        dfs(root, max);
        return goodNodes;   
    }
    
    private void dfs(TreeNode root, int max){
        if(root == null) return;
 
        if(max <= root.val){
            max = root.val;
            goodNodes++;
        }
        dfs(root.left, max);   
        dfs(root.right, max);
    }
}