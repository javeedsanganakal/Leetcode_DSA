//Approach - 2: 4 Pointers
//Time Complexity : O(n)
//Space Complexity : 

class Solution {
    public boolean isMatch(String s, String p) {
        if(s.equals(p) || p.equals('*')) return true;
        int sLen = s.length();
        int pLen = p.length();
        
        int sp = 0;
        int pp = 0;
        
        int sStar = -1;
        int pStar = -1;
        
        while(sp < sLen){
            //1st Case
            if(pp < pLen && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')){
                sp++;
                pp++;
            }
            //2nd Case
            else if(pp < pLen && p.charAt(pp) == '*') { 
                sStar = sp;
                pStar = pp;
                pp++;
            }
            //3rd Case
            else if(pStar == -1){
                return false;
            }
            //4th Case
            else{
                sp = sStar + 1;
                sStar = sp;
                pp = pStar + 1;
            }
        }
        
        while(pp < pLen){
            if(p.charAt(pp) != '*') return false;
            pp++;
        }
        return true;
    }
}