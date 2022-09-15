//Approach - 2: DFS; call dfs(maze, start, destinaion)
//Time Complexity : O(k*mn) ==> O(mn)
//Space Complexity : O(n) // reucrsion in stack

class Solution {
    int [][] dirs;int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        
        m = maze.length;
        n = maze[0].length;
        
        dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}}; //top right bottom left.
        
        return dfs(maze, start, destination);
        
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination){
        //base
         if(start[0] == destination[0] && start[1] == destination[1]) return true;
         if(maze[start[0]][start[1]] == 2) return false;
        
        //logic
        //make visted
         maze[start[0]][start[1]] = 2;
        
        for(int[] dir : dirs){
            int i = start[0];
            int j = start[1];
            //if its 0 or 2 just we will pass through, till we reach walls or 1
            while(i>= 0 && i<m && j>=0 && j<n && maze[i][j] != 1){
                i = i + dir[0]; 
                j = j + dir[1];      
            }
                // 1 step back
                i = i-dir[0];
                j = j-dir[1];
            if(dfs(maze, new int[]{i,j}, destination)) return true;
        }
        return false;
    }
}