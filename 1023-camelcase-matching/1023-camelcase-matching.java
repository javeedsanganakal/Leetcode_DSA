//Approach - 1 : 2 Pointers 
//Time Complexity : n * Max(m,k)
//Space Complexity : O(1)

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        
        for(String query : queries){
            boolean flag = false;
            int i = 0; int j = 0;
            
            while(i < query.length()){
                char ch = query.charAt(i);
                if(j < pattern.length() && ch == pattern.charAt(j)){
                    j++;
                    if(j == pattern.length()) {
                       flag = true;
                    }
                }
                else if(Character.isUpperCase(ch)){
                    flag = false;
                    break;
                }
                i++; 
            }
            result.add(flag);    
        }
        return result;
    }
}