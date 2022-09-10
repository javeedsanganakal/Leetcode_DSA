//Technique1 : Two Pointers and HashSet
//Time Complexity : O(n)
//Space : Complexity : O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> set = new HashSet<>();
        
        
        int max = 0;
        int slow = 0;
        for(int i=0; i< s.length();i++){
            char c = s.charAt(i);
            
            while(set.contains(c)){
                set.remove(s.charAt(slow));
                slow ++;
            }
            set.add(c);
            max = Math.max(max, i-slow+1);
        }
        
        return max;
    }
}