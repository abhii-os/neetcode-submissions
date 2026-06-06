class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int left = 0;
        int right = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        
        while(left<len1 && right<len2){
            result.append(word1.charAt(left));
            result.append(word2.charAt(right));
            left++;
            right++;
        }

        if(left<len1){
            result.append(word1.substring(left));
        }
        if(right<len2){
            result.append(word2.substring(right));
        }
        return result.toString();
    }
}