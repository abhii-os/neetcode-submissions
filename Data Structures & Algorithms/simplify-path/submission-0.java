class Solution {
    public String simplifyPath(String path) {
        String [] components = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String comp : components){
            if(comp.equals("..")){
                if(!stack.isEmpty()){
                    stack.pollLast();
                }
            }
            else if(comp.equals(".")||comp.equals("")){
                continue;
            }
            else{
                stack.addLast(comp);
            }
        }
        StringBuilder result = new StringBuilder();
        for(String dir:stack){
             result.append("/").append(dir);
        }
        return result.length() == 0? "/":result.toString();

    }
}