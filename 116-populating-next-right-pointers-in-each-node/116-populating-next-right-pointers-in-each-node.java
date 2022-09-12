/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/


//Approach - 2 : Without Queue, prev, curr  , Best Approach ***
//Time Complexity : O(n)
//Space Complexity : O(1)
class Solution {
    public Node connect(Node root) {        
        //if root is null , return null node
        if(root == null) return null; 
        
        //level nodefor iterating each node
        Node level = root;

        //we will iterate til last child, i.e level.left != null
        while(level.left != null){
            
            //root ==> level ==> curr // node 1
            //Intialize curr for every level
            Node curr = level;

            //loop every level
            while(curr != null){               
                curr.left.next = curr.right;               
                //except last node 
                if(curr.next != null){
                  curr.right.next = curr.next.left;
                }                   
                curr = curr.next;
            }            
            //move to next level
            level = level.left;                
        }    
     return root;
    }
}