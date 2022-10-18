//Approach - 1: Linear
//Time Complexity : O(n)
//Space Complexity : O(l) // all the sub strings 

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        
        for(int i=0; i<=n-10; i++){
            String sub = s.substring(i,i+10);
            //if same string with len 10 already contains in set
            if(set.contains(sub)){
                result.add(sub);
            }
            set.add(sub);
        }
        return new ArrayList<>(result);
    }
}