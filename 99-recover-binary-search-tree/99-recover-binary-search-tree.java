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
//Nodes
class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    boolean flag;
    //TreeNode curr // root only
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        
        //swap the values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root){
        //base
        if(root == null) return;
        
        
        //logic
        inorder(root.left);
        
        //breach happens
        if(prev != null && prev.val > root.val){
            //first breach
            if(!flag){ 
                flag = true;
                first = prev;
                second = root;
            }
            else{ // second breach
                second = root;
            }
        }
        
        prev = root;
        inorder(root.right);
        
       
    }
}