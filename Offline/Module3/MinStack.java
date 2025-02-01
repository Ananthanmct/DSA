class MinStack {

    Stack<Integer> normalStack;
    Stack<Integer> minStack;
    public MinStack() {
        normalStack = new Stack<>();
        minStack = new Stack<>();
        
    }
    
    public void push(int val) {

        normalStack.push(val);
        if(minStack.size() == 0){
            minStack.push(val);
        }else{
            int min = Math.min(val, minStack.peek());
            minStack.push(min);
        }
        
    }
    
    public void pop() {
        normalStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return normalStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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
