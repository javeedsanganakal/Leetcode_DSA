class Solution {
    //edges = prerequsities == [[1,0],[2,0],[3,1],[5,2],[3,1],[4,1],[5,4]]
    //numCourses = 6
    public boolean canFinish(int numCourses, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        int [] indegrees = new int[numCourses]; //size 6 array int[6]
        
        //[0, 1, 1, 2, 1, 2] indegree Array of length courses
        // 0, 1, 2, 3, 4, 5
        
        for(int [] edge: edges){
            
            indegrees[edge[0]]++; //indegrees[1]
            
            //independent to dependent
            
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());   
            }
            
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        
        int count = 0;
        for(int i=0; i<numCourses; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count ++;
            }
        }
        
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            //reduce the indegrees of babies
            List<Integer> children = map.get(curr);
            
            if(children != null){
                for(int child: children){
                    indegrees[child]--;
                    
                    if(indegrees[child] == 0){
                        q.add(child);
                        count++;
                    if(count == numCourses) return true;
                    }
                }
            }
        }
        return count == numCourses;
    }
}