//Approach - 1: bfs, queue
//Time Complexity : O(m*n)  ==> 2mn
//Space Complexity : Min(m,n)

class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        
        int[][] dirs = new int[][] {{-1,0}, {0,1}, {1,0}, {0,-1}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]  == '1'){
                    count++;
                    Queue<int[]> q = new LinkedList<>(); 
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    
                    
                    while(!q.isEmpty()){
                        int [] curr = q.poll();
                        for(int[] dir: dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1]; 
                            //check boundaries
                            if(nr >=0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1'){
                                q.add(new int[]{nr, nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }   
}
