//Approach - 1: In and out 2 stacks, 'U' shapped from => in to out => order like FIFO rule.
//Time Complexity : O(1)
//Space Complexity : O(n)

class MyQueue {
    //
    private Stack<Integer> in; // to push
    private Stack<Integer> out; // to pop
    public MyQueue() {
        this.in = new Stack<>(); // 
        this.out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        peek();
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */