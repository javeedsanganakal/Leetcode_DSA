//Approach - 1: dfs 
//Time Complexity : O(M×N) where MM is the number of rows and NN is the number of columns.
//Space Complexity : O(m*n) worst case O(M \times N)O(M×N) in case that the grid map is filled with lands where DFS goes by M \times NM×N deep.

class Solution {
     int m;
     int n;
     public int numIslands(char[][] grid) {
        //edge case
        m = grid.length;
        if(grid == null || m == 0) return 0;
        n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;    
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs (char[][] grid, int i, int j){
        // base case
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        int[][] dirs = new int [][] {{0,1},{1,0}, {-1,0},{0,-1}};
        grid[i][j] = '0';
        for(int[] dir: dirs){
            int r = i+dir[0];
            int c = j+dir[1];
             dfs(grid,r,c);
        }
    }
}