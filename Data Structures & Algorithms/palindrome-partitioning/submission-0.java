class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(s,0,result,path);
        return result;
    }
    private void backtrack(String s, int index, List<List<String>> result, List<String> path){
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            
            if(isPalindrome(s,index,i)){
                String sub = s.substring(index,i+1);
                path.add(sub);
                backtrack(s,i+1,result,path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high){
        while(low<=high){
            if(s.charAt(low)!=s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
