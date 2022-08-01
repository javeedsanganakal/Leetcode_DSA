class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        
        int [] result = new int[n];
        
        if(nums == null || nums.length == 0) return result;
        
        int runningProduct = 1;
        result[0] = 1;
        
        //Left runningProduct 
        //nums = [1,2,3,4]
        for(int i=1; i<n;i++){ 
            runningProduct *= nums[i-1];
            result[i] = runningProduct;
        }

        //result = [1,1,2,6] //left runningProduct
        
        //System.out.println(Arrays.toString(result));
        
        //right runningProduct
        runningProduct = 1;
        for(int j=n-2; j>=0; j--){
            runningProduct = runningProduct*nums[j+1]; 
            result[j] = result[j] * runningProduct;
        }
        //nums = [1,2,3,4] 
        //result = [1,1,2,6] left
        
        // result = [24,12,4,1] 
        return  result;  
    }
}