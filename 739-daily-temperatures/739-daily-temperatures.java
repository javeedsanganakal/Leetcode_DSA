//Approach - 2: Monotonic Dec Stack
//Time Complexity : O(n) 
//Space Complexity : O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        
        int[] result = new int[n];
        
        //Monotonic Decreasing Stack 4,3,2,1
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int poppedIndex = st.pop();
                result[poppedIndex] = i - poppedIndex;
            }
            st.push(i);
        }
        return result;
    }
}