//Approach - 1: 2 stacks-> st and minStack, minValue = Infinity
//Time Complexity : O(1) 
//Space Complexity : 
class MinStack {
    
    private Stack<Integer> st;
    private Stack<Integer> minStack;
    private int min;
    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minStack= new Stack<>();
        minStack.push(min);
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        st.push(val);
        minStack.push(min);
        
    }
    
    public void pop() {
        st.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */