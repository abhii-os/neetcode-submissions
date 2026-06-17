class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int a = 0;
        int b = 0;
        int newValue = 0;
        for(String ch : tokens){
            if(ch.equals("+")){
                b = stack.pop();
                a = stack.pop();
                newValue = a+b;
                stack.push(newValue);
            }
            else if(ch.equals("*")){
                b = stack.pop();
                a = stack.pop();
                newValue = a*b;
                stack.push(newValue);
            }
            else if(ch.equals("-")){
                b = stack.pop();
                a = stack.pop();
                newValue = a-b;
                stack.push(newValue);
            }
            else if(ch.equals("/")){
                b = stack.pop();
                a = stack.pop();
                newValue = a/b;
                stack.push(newValue);
            }
            else{
                stack.push(Integer.parseInt(ch));
            }

        }
        return stack.pop();
    }
}
