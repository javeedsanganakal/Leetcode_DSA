class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstArray = new ArrayList<>();
        
        if(numRows == 0) return result;
        
        firstArray.add(1);
        result.add(firstArray);
        
        
        for(int i=1; i< numRows; i++){
            List<Integer> newList = new ArrayList<>();
            //add 1 at begining 
            newList.add(1);
            
            for(int j=1; j<i; j++){
                newList.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            
            //add 1 at ending 
            newList.add(1);
            result.add(newList);
        }
        return result;
    }
}