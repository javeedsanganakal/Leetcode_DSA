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
    Stack<TreeNode> st;
    List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
         result = new ArrayList<>();
        st = new Stack<>();
        inorder(root);
        return result;
    }
    
    private void inorder(TreeNode root){
        //base
        if(root == null) return;
    
        //logic
        st.push(root);

        inorder(root.left);
        result.add(st.pop().val);
        inorder(root.right);
    }
}