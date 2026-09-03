class Solution {
     private static final String[] Keypad = {
        "",
        "",
        "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
     
    public List<String> letterCombinations(String digits) {
     List<String> result = new ArrayList<>();
     StringBuilder current = new StringBuilder();
     if(digits==null || digits.length()==0){
        return result;
     }
     backtrack(0,digits,result,current);
     return result;
    }

    private void backtrack(int index, String digits, List<String> result, StringBuilder current){
        if(index == digits.length()){
            result.add(current.toString());
            return;
        }
        String letters = Keypad[digits.charAt(index)-'0'];

        for(char c:letters.toCharArray()){
            current.append(c);
            backtrack(index+1,digits,result,current);
            current.deleteCharAt(current.length()-1);
        }
    }
}
