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
//Approach - 2: DFS
//Time Complexity : O(V+E) ; vertices and edges
//Space Complexity : O(V); vertices

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if(node == null) return null;
        dfs(node);
        return map.get(node);
    }
    private void dfs(Node node){
        //base
        if(map.containsKey(node)) return;
        //logic
        
        //add
        Node tempNode = new Node(node.val);
        map.put(node, tempNode);
        
        for(Node child: node.neighbors){
            dfs(child);
            map.get(node).neighbors.add(map.get(child));
        }
    }
}