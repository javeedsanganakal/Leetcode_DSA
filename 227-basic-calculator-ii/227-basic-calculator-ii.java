//Approach - 1  : Stack
//Time Complexity : O(n) length of the string
//Space Complexity : O(n)
class Solution {
    public int calculate(String s) {

        if(s == null || s.length()  == 0) return 0;
        
        
        
        //Intailly LastSign and curr + and 0  asssume
        char lastSign = '+';
        int curr = 0;
        
        Stack<Integer> st = new Stack<>();


        for(int i=0; i< s.length(); i++){
            
            char c = s.charAt(i);
            
            
            //Case 1: Digit
            //if its  digit assign to curr
            if(Character.isDigit(c)){
                //ASCII Value of 3 and 0 // 51 - 48
                curr = curr*10 + c-'0'; // if s = "42"
            }
            
        
            
            //Case 2: Operator
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1){
                if(lastSign == '+'){
                    st.push(curr);
                }
                else if(lastSign == '-'){
                    st.push(-curr);
                }
                else if(lastSign == '*'){
                    st.push(st.pop()*curr);
                }
                else {
                    st.push(st.pop()/curr);
                }
                curr = 0;
                lastSign = c;
            }
            
        }
        int result = 0; 

        while(!st.empty()){
            result += st.pop();
        }
        return result;
    }
}