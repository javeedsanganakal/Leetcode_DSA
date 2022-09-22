//Approach - 1: Breach, find next greater, reverse
//Time Complexity : O(n)
//Space Complexity : O(1)

class Solution {
    public void nextPermutation(int[] nums) {
        
        if(nums == null) return;
        int n = nums.length;
        
        //1. find the breach
        int i = n-2;
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        
        //2. find the jth elemenet to replace ith element
        if(i!=-1){
            int j=n-1;
            while(nums[i] >= nums[j]){
                j--;
            }
            //swap i and j
            swap(nums,i,j);
        }
        
        //3. reverse from i+1 to n-1
        reverse(nums,i+1,n-1);
    }
    private void swap(int [] nums, int i, int j){
        // int temp = nums[i];
        // nums[i] = nums[j];
        // nums[j] = temp;
        
        // without using temp variable
        if(i!=j){
        nums[i] = nums[i] + nums[j]; // 4 and 5 == 9
        nums[j] = nums[i] - nums[j]; // 9 -5 == 4
        nums[i] = nums[i] - nums[j]; // 9-4 == 5
        }
        
    }
    
    private void reverse(int [] nums, int left, int right){
        while(left<right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}