/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Notes

//Important Algorithm ****
//Approach -  3 : Recursion
//Time Complexity : O(n)
//Space Complexity : O(h)

class Solution {
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,  p,  q);
        TreeNode right = lowestCommonAncestor(root.right,  p,  q);
        
        if(left == null && right == null) return null; // not found
        else if(left == null && right != null) return right; //left side
        else if(left != null && right == null) return left; // right side 
        else return root; // p, q are both sides

    }
}