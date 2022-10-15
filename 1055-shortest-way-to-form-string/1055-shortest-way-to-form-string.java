//Approach - 1: 2. Pointers, HashSet
//Time Complexity : O(m*n)
//Space Complexity : O(1)

class Solution {
    public int shortestWay(String source, String target) {
        //we have to form subseq of target from source
        int sourceLen = source.length();
        int targetLen = target.length();
        
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<sourceLen; i++){
            set.add(source.charAt(i));
        }
        
        int targetPointer = 0;
        int sourcePointer = 0;
        int count = 1;
        while(targetPointer < targetLen){
            char sChar = source.charAt(sourcePointer);
            char tChar = target.charAt(targetPointer);
            
            if(!set.contains(tChar)) return -1;
            
            if(sChar == tChar){
                targetPointer++;
                sourcePointer++;
                if(targetPointer == targetLen) return count;
            }
            else{
                sourcePointer++;
            }
            
            if(sourcePointer == sourceLen){
                //reset the count, after froming a subsequence
                sourcePointer = 0;
                count++;
            }
        }
        return count;
    }
}