//Approach - 2:HashMap and HashSet;
//Time Complexity : O(n) length of the string
//Space Complexity : O(1)==> O(26) alphabets
class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        HashMap<Character, Character> sMap = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        
        for(int i=0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            //sMap
            if(sMap.containsKey(sChar)){
                if(sMap.get(sChar) != tChar) return false;
            }
            else{
                if(set.contains(tChar)){
                    return false;
                }
                else{
                    sMap.put(sChar, tChar);
                    set.add(tChar);
                }     
            }      
        }
        return true;        
    }
}