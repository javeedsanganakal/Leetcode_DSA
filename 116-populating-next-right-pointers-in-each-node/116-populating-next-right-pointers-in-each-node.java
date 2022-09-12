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


//Approach - 1: Queue, prev, curr 
//Time Complexity : O(n)
//Space Complexity : O(n)
class Solution {
    public Node connect(Node root) {
        
        if(root == null) return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node prev = null;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node curr = q.poll(); 
                if(i!=0){
                    //Pointing next node
                    prev.next = curr;
                }
                //add the childrens
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                prev = curr;       
            }
         }
         
         return root;
    }
}