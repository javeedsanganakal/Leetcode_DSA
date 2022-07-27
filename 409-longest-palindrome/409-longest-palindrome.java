class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        
        for(int i=0; i<s.length(); i++){
            char sChar= s.charAt(i);
            if(set.contains(sChar)){
                count +=2;
                set.remove(sChar);   
            }
            else{
                set.add(sChar);
            }
        }
        if(!(set.isEmpty())) count+=1;
        return count;
    }
}