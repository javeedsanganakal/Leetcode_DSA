class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
         if(matrix == null || matrix.length == 0) return false;
        
        
        int m = matrix.length; // 5  rows
        int n = matrix[0].length; //5 cols
        
         
        int i = 0; // i = rows - 1 = m-1 = 5-1 = 4
        int j = n-1; // j = cols = 0
            
            while(i < m && j >=0){ 
                if(matrix[i][j] == target)  return true;             
                
                if(matrix[i][j] > target){ 
                    j--;

                }else{
                    i++;
                }
            }
            
        return false;
    }
}