class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(0,0, n,result,sb);
        return result;

    }

    private void backtrack(int open, int close, int n, List<String> result, StringBuilder sb){
        if(sb.length()==2*n){
            result.add(sb.toString());
        }

        if(open<n){
            sb.append('(');
            backtrack(open+1,close,n,result,sb);
            sb.setLength(sb.length()-1);
        }

        if(close<open){
            sb.append(')');
            backtrack(open,close+1,n,result,sb);
            sb.setLength(sb.length()-1);
        }

    }
}
