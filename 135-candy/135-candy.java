//Approach - 1: Greedy, Array fill with 1, move left to right and right to left.
//Time Complexity :  O(n),  2*n times
//Space Complexity : O(n)

//Greedy: Local optima lead to Global optima

class Solution {
    public int candy(int[] ratings) {
       
        if(ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        if(n==1) return 1;
        
        int[] result = new int[n];
        
        //Each child must have at least one candy.
        Arrays.fill(result, 1);
        
        //Children with a higher rating get more candies than their neighbors.
        
        //Move left to right, forward pass
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                result[i] = 1 + result[i-1];
            }
        }
        
        //minimum number of candies 
        int sum = result[n-1];
        
        //Move right to left and take max btw (curr, prev+1), backward pass
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                result[i] = Math.max(result[i], 1 + result[i+1]); 
            }
            sum += result[i];
        }
        return sum;
    } 
}