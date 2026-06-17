class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int ast:asteroids){
            boolean alive = true;

            while(alive && !stack.isEmpty() && stack.peek()>0 && ast<0){
                if(stack.peek()<Math.abs(ast)){
                    stack.pop();
                    continue;
                }
                else if(stack.peek()==Math.abs(ast)){
                    stack.pop();
                    alive=false;
                }
                else{
                    alive = false;
                }
            }
            if(alive){
                stack.push(ast);
            }
        }
        int[] result = new int[stack.size()];
        for(int i = result.length-1;i>=0;i--){
            result[i]=stack.pop();
        }
        return result;
    }
}