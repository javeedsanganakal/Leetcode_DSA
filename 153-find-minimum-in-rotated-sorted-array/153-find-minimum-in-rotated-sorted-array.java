//Approach - 1 : Binary Search
//Time Complexity : O(logn)
//Space Complexity : O(1)
class Solution {
    public int findMin(int[] nums) {
        int result = nums[0];
        
        int l = 0;
        int h = nums.length-1;

        
        while(l<=h){
            
            //if sorted 
            if(nums[l] < nums[h]){
                result = Math.min(result, nums[l]);
                return result;
            }
            
            int mid = l+(h-l)/2;
            
            result = Math.min(result, nums[mid]);
            
            if(nums[l] <= nums[mid]){
                //search right
                l = mid+1;
            }
            else{
                //Search left
                h = mid-1;
            }
        }
          return result;                                  
    }
}