class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] result = new int[n];
        
        if(nums == null || nums.length == 0) return result;
        
        int runningProduct = 1;
        result[0] = 1;
        
        //Left runningProduct 
        for(int i=1; i<n;i++){ 
            runningProduct *= nums[i-1];
            result[i] = runningProduct;
        }
        
        //right runningProduct
        runningProduct = 1;
        for(int j=n-2; j>=0; j--){
            runningProduct = runningProduct*nums[j+1];
            result[j] = result[j] * runningProduct;
        }
        return  result;  
    }
}