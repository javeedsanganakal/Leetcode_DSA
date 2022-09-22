//Approach - 2 : max, currSum,  currSum= max(currSum + nums[i], nums[i]) , max(max, currSum)
//Time Complexity : O(n)
//Space Complexity : O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = nums[0];
        int currSum = nums[0];
        for(int i=1; i<nums.length; i++){
            currSum = Math.max(currSum + nums[i], nums[i]);
            max = Math.max(max, currSum);
        }
        return max;
    }
}