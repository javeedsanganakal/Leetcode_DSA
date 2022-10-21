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
    List<List<Integer>> result;
    public List<List<Integer>> findLeaves(TreeNode root) {

    result = new ArrayList<>();
        
    dfs(root); 
    return result;
    }
    
    private int dfs(TreeNode root){
        //base
        if(root == null) return -1;
        
        //logic
        int lh = dfs(root.left);
        int rh = dfs(root.right);
        
        int rootHieght = Math.max(lh, rh) + 1;
        
        if(rootHieght == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(rootHieght).add(root.val);
        
        return rootHieght;
    }
}