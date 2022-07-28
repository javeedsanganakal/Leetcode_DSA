class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int runningSum = 0;
        int count = 0; // result
            for(int i=0;  i< nums.length; i++){
                runningSum = runningSum+nums[i]; 
                
                //Increment the count of SubArrays in HashMap  => x+y=z , y=k, z = runningSum
                if(map.containsKey(runningSum-k)){ // z-y = x
                    count = count+ map.get(runningSum-k);
                }
                
                //Add runningSum in HashMap
                if(!map.containsKey(runningSum)){
                    map.put(runningSum, 0);
                }
                map.put(runningSum, map.get(runningSum)+1); 
            }
        return count;
        
        
    }
}