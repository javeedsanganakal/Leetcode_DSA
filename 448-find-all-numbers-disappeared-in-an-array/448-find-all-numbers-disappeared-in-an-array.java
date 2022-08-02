class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        
        List<Integer> missingNumbers = new ArrayList<Integer>();
        HashSet<Integer> numbers = new HashSet<Integer>();
        
        for(int i:nums){
            numbers.add(i);
        }
        
        for(int i=1;i<=n;i++){
            if(!(numbers.contains(i))){
                missingNumbers.add(i);
            }
        }
        return missingNumbers;
        
    }
}