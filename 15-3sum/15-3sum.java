class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        //Declare List of Integers List
        List<List<Integer>> result = new ArrayList<>();
        
        //return the empty ArrayList
        if(nums == null || nums.length == 0) return new ArrayList<>();
        int n = nums.length;
        
        //Sort the unsorted Array O(nlogn)
        Arrays.sort(nums);
        
        //loop till 3rd num from last
        for(int i=0; i < n-2; i++){
            
            // if
            if(i!=0 && nums[i] == nums[i-1]) continue;
            
            int low = i+1;
            int high = n-1;
            
            while(low<high){
                int sum = nums[i] + nums[low] + nums[high];
                
                if(sum == 0) {
                    //List of Integers
                    List<Integer> li = Arrays.asList(nums[i], nums[low], nums[high]);
                    
                    // Sorted array no need to sort and add to list
                    result.add(li);  
                    
                    //Inc low pointer
                    low++; 
                    //Dec high pointer
                    high--;
                    
                    //Duplicates from left side, increase the low pointer
                    while(low<high && nums[low] == nums[low-1]) low ++;
                     //Duplicates from right side, decrease the low pointer
                    while(low<high && nums[high] == nums[high+1]) high--;
                }
                //if sum is greater thaan target, decr the high to get the target
                else if(sum > 0){
                    high--;
                }
                 //if sum is smaller thaan target, incr the low to get the target
                else{
                    low++;
                }
            }
        }
        
        return result; 
    }
}