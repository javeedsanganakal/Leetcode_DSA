/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
//Approach - 1: BFS
//Time Complexity : O(V+E) ; vertices and edges
//Space Complexity : O(V); vertices

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        
        map = new HashMap<>();
        
        if(node == null) return null;
        
        //Deep copy of node val
        Node tempNode = new Node(node.val);
        map.put(node, tempNode);
        
        //add the Original node to Queue
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            
            for(Node child: curr.neighbors){
                Node childTemp = new Node(child.val);
                
                if(!map.containsKey(child)){
                    //add the curr neighbors and its temp node to map
                    map.put(child, childTemp);
                    //add curr neighbor to queue
                    q.add(child);
                }
                
                //Original nodes deep copy, get its neighbors, and add deep copy of child
                map.get(curr).neighbors.add(map.get(child));
                
            }
        }
        //return map.get(node);
        return tempNode;
    }
}