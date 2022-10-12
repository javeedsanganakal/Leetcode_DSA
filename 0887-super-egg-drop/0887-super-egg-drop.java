//Approach - 1: DP
//Time Complexity : nk 
//Space Complexity : nk

class Solution {
    public int superEggDrop(int k, int n) { 
        int[][] dp = new int[n+1][k+1]; 
        
        int attempts = 0;
        //we will return, when the explore number exceeds n and then return the attemps
            while(dp[attempts][k] < n){
            attempts++;
            for(int j = 1; j <= k; j++){ //Not Break       //Break
                dp[attempts][j] = 1 + dp[attempts-1][j] + dp[attempts-1][j-1];
            }
        }
        return attempts;
    }
}