//Approach - 1 : firstIdx = Binary1; secondIdx = Binary Search by using first index value till n
//Time Complexity : O(logn)
//Space Complexity : O(1)

class Solution {
    int lowFromFirst;
    
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        int n = nums.length;
        if(nums[0] > target || nums[n-1] < target) return new int[]{-1,-1};
        
        int first = binarySearchFirst(nums, target);
        int last = binarySearchLast(nums, first, n-1, target);
        return new int[] {first, last};
        
    }
    
     private int binarySearchLast(int[] nums, int low, int high, int target){

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]  == target){
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]){
                    return mid;
                }
                else{
                    //move right
                    low = mid+1;
                }
            }
            else if(nums[mid]  < target){
                 low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
     }
    
    private int binarySearchFirst(int[] nums, int target){
        int low = 0; 
        int high = nums.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]  == target){
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }
                else{
                    //move left
                    high = mid-1;
                }
            }
            else if(nums[mid]  < target){
                 low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
   
}