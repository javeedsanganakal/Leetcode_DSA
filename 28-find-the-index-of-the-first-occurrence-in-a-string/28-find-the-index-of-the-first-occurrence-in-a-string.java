
class Solution {
    public int strStr(String haystack, String needle) {
        
        int hayStackLen = haystack.length();
        int needleLen = needle.length();
        for(int i=0; i<hayStackLen-needleLen+1; i++){   
           String ans=haystack.substring(i,i+needleLen);
           if(ans.equals(needle)){
               return i;
           }
       }
        return -1;
    }
}