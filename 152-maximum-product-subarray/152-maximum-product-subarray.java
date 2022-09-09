
class Solution {
    public int maxProduct(int[] nums) {
        
        int p = 1;
        int result = Integer.MIN_VALUE;
        int n = nums.length;
        
        for(int  i =0; i<n; i++){
            
            p = p * nums[i];
            result = Math.max(p, result);
            
            if( p == 0){
                p = 1;
            }
        }
        
        p = 1;
        for(int j = n-1; j >=0; j--){
            
            p = p * nums[j];
            result = Math.max(p, result);
            
            if( p == 0){
                p = 1;
            }
        }
        return result;
    }
}
