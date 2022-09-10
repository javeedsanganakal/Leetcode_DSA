/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Approach - 1 : Recursive 
//Time Complexity : O(h) // logarithemic
//Space Complexity : O(h) // Stack calls

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else return root;
    }
}