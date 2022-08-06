class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
         if(matrix == null || matrix.length == 0) return false;
        
         // return true;
        
        int m = matrix.length; // 5
        int n = matrix[0].length; //5
         
        int i = m-1; // row = 0
        int j = 0; // col = 5-1 = 4
            
            while(i >= 0 && j < n){ //  // j >=0 => 
                if(matrix[i][j] == target)  return true;
                
                // if(matrix[i][j] == target) return true; // 15 != 15 
                
                if(matrix[i][j] > target){ //15< 5
                    i--;
                    // 5-1 => 4,3,2,1, 0 ===> j >=0
                }else{
                    j++;
                    //i < 5 => 0, 1, 2, 3, 4
                }
            }
            
        return false;
    }
}