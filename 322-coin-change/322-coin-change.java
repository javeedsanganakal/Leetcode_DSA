class Solution {
    public int coinChange(int[] coins, int amount) {
        
        
        //No coins in an array return 0
        if(coins == null || coins.length == 0) return 0;
        
        // m no of rows for matrix
        int m = coins.length;
        
        //no of columns for matrix
        int n = amount;
        
        // declare  2D array for matrix 
        // m+1 extra row, n+1  extra column
        int [][] dp = new int[m+1][n+1];
        
        //top row first  value intialize with zero
        dp[0][0] = 0;
        
        //top row
        //dp[0].length first row length
        
        for(int j =1 ; j < dp[0].length; j++){
            
            dp[0][j] = amount + 1;
        }
        
        for(int i=1; i<dp.length; i++){ // no of rows 
            for(int j=1; j<dp[0].length; j++){ // no of columns
                if(j<coins[i-1]){ // cloumn - coin i.e., till coin steps back -> copy the values from above row
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j]  = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]); // min of (above values) and (1+ coin steps back)
                }
            }
           
        }
         int result = dp[m][n];  // end value of 2D array is our result 
            if(result>amount) return -1; // if result is  infinity or amount + 
            return result;
        
        
        
        
        
    }
}