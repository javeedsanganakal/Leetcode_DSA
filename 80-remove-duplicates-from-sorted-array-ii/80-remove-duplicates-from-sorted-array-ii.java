class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        int count = 1;
        int slow = 1;
        
    for(int i = 1; i < nums.length; i++){
        
         // Duplicates count
        if(nums[i] == nums[i-1]){
            count++;
        }
        else{
            count = 1;
        }
        
        // Over write the numbers
        if(count <= 2){
            nums[slow] = nums[i];
            slow++;
        }
      }
        return slow;
    }
}