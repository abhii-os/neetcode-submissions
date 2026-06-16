class Solution {
    public int calPoints(String[] operations) {
       Deque<Integer> stack = new ArrayDeque<>();

       for(String op:operations){
            if(op.equals("+")){
                int top = stack.pop();
                int newScore = top + stack.peek();

                stack.push(top);
                stack.push(newScore);
            }
            else if(op.equals("D")){
                stack.push(2*stack.peek());
            }
            else if(op.equals("C")){
                stack.pop();
            }
            else{
                stack.push(Integer.parseInt(op));
            }
       } 
       int totalSum = 0;
       while(!stack.isEmpty()){
        totalSum += stack.pop();
       }
       return totalSum;
    }
}