class MinStack {
private Deque<Integer> mainStack;
private Deque<Integer> minStack;
    public MinStack() {
        mainStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        mainStack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
       if(mainStack.peek().equals(minStack.peek())){
        minStack.pop();
       }
       
       mainStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
