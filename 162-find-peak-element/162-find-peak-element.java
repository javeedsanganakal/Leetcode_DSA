//Approach - 1 : Binary Search, Move towards the any greater side , 
//Time Complexity : O(logn)
//Space Complexity : O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            // left side first element and righ side last element
            if( (mid == 0 || nums[mid] > nums[mid-1]) && 
               (mid == nums.length-1 || nums[mid] > nums[mid+1]) ){
                return mid;
            }
            else if(mid > 0 && nums[mid-1] > nums[mid]){
                //left
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return 1; // return -1 also works
    }
}