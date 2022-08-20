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

//TC = O(n) 
//SC = O(h)

//Using BFS right side
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        dfs(root, 0, result);
        return result;
    }
    private void dfs(TreeNode root, int depth, List<Integer> result){
        //base
          if(root == null) return; 
        
        //logic
        //depth of a tree and result list size, initially both 0 and 0, so add root
        if(depth == result.size()){
            result.add(root.val);
        } else{
            result.set(depth, root.val); //replace
        }
        
        dfs(root.left, depth+1, result);
        dfs(root.right, depth+1, result);
        
        
    }
}