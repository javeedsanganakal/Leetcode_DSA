//Approach - 2: 2 Arrays , sArr , tArr , ascii value char -' '; gives index
//Time Complexity : O(n) length of the string
//Space Complexity : O(1)==> O(26) alphabets
class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        char[] sMap = new char[256]; // number of ascii values;
        char[] tMap = new char[256];

        
        for(int i=0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            //sMap
            if(sMap[sChar - ' '] != 0){
                if(sMap[sChar - ' '] != tChar) return false;
            }
            else{
                sMap[sChar - ' '] =  tChar;
            }
            
            //tMap
            if(tMap[tChar - ' '] != 0){
                if(tMap[tChar - ' '] != sChar) return false;
            }
            else{
                tMap[tChar-' '] =  sChar;
            }
        }
        return true;
        
    }
}