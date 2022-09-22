//Approach - 1 : max, currSum, if curr< 0 : currSum = 0;
//Time Complexity : O(n)
//Space Complexity : O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = nums[0];
        int currSum = 0;
        for(int i=0; i<nums.length; i++){
            
            if(currSum < 0){
                currSum = 0;
            }
            
            currSum = currSum + nums[i];
            max = Math.max(max, currSum);
        }
        return max;
    }
}