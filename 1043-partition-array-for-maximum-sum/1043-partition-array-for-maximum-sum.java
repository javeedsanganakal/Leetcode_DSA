//Approach - 1: Make K partition for each element and max
//Time Complexity :  O(k*n)
//Space Complexity : O(1) // we need only last k elements maintain 2 arrays and keep overwrting;
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0) return 0;
        int n = arr.length;
        
        int[] dp = new int[n]; 
        dp[0] = arr[0]; // 1, 
         
        for(int i = 1; i<n; i++){
            
            int max = arr[i]; // 15
            for(int j=1; j<=k && i-j+1 >=0; j++){
                
                max = Math.max(max, arr[i-j+1]); // arr[1-1+1] = 15 ; 15, 1
                
                int currPart = max*j;
                
                if(i-j>=0){
                    currPart = max*j + dp[i-j];
                }   
                dp[i] = Math.max(dp[i], currPart);
            }
        }
        return dp[n-1];
    }
}