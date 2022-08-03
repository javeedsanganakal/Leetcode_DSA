class Solution {
    
    int m;
    int n;
    int [][] dirs;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        
        //1 ==> 0 ==> 2
        //0 ==> 1 ==> 3
        
        //               top    bottom    left     right  topLeft   topRight   
        dirs = new int[][]{{-1,0}, {1,0},  {0,-1},  {0,1},  {-1,-1},  {-1,1},   {1,-1},  {1,1} };
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int countlives = countAlive(board, i, j);

                //2 No need implement
                //1th and 3rd Rule
                if(board[i][j] == 1 && (countlives < 2 ||  countlives > 3)){
                    board[i][j] = 2;
                }
                
                //4th Rule
                if(board[i][j] == 0 && countlives == 3){
                    board[i][j] = 3;
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2) board[i][j] = 0;
                if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }
    
    private int countAlive(int [][] board, int r, int c){
        int count = 0;
        for(int []dir : dirs){
            int nr = r + dir[0];  //{-1,0} ==> -1
            int nc = c + dir[1];  //{-1,0} ==>  0
            
            //borders of columns and rows. condition without crossing
            // nr ==> 0 to m   and  cr ==> 0 to n
            if(nr >= 0 && nr < m && nc >= 0 && nc < n
              && (board[nr][nc]==1 || board[nr][nc] == 2)){
                count ++;
            }
        }
        
        return count;
    }
}