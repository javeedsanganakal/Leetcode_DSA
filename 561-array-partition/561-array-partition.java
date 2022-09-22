//Approach - 1: Sort the Array, Increment by 2
//Time Complexity : O(nlogn)
//Space Complexity : O(1)

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        for(int i=0; i<nums.length; i+=2){
            result += nums[i];
        }
        return result;
    }
}