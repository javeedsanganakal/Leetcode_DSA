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


//Approach - 1.3: Queue, prev, curr  ***
//Time Complexity : O(n)
//Space Complexity : O(n)
class Solution {
    public Node connect(Node root) {
        
        if(root == null) return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;
            for(int i=0; i<size; i++){
                Node curr = q.poll(); 
                curr.next = prev;
                //add the childrens
                if(curr.left != null) q.add(curr.right);
                if(curr.right != null) q.add(curr.left);
                prev = curr;       
            }
         }
         
         return root;
    }
}