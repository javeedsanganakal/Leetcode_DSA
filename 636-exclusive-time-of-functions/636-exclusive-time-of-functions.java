class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        if(logs == null) return new int[0];
        
        //no of functions
        int[] result = new int[n];
        
        //timings
        int prev = 0;
        Stack<Integer> st = new Stack<>();
        
        for(String log: logs){
            String[] strArr = log.split(":");
            
            int functionCall = Integer.parseInt(strArr[0]);
            int curr = Integer.parseInt(strArr[2]);
            
            if(strArr[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] = result[st.peek()] + (curr-prev);
                }
                prev = curr;
                st.push(functionCall);
            }
            else{
                result[st.peek()] = result[st.peek()] + (curr+1-prev);
                
                st.pop();
                prev = curr + 1;  
            } 
        }
        return result;
    }
}