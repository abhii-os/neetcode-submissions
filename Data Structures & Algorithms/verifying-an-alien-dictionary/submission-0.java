class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charOrder = new int[26];
        for(int i=0;i<order.length();i++){
            charOrder[order.charAt(i)-'a'] = i;
        }

        for(int i=0; i<words.length - 1;i++){
            if(!isSorted(words[i],words[i+1],charOrder)){
                return false;
            }
        }
        return true;
    }
    private boolean isSorted(String w1, String w2, int[] charOrder){
        int len1 = w1.length();
        int len2 = w2.length();
        int minLen = Math.min(len1,len2);

        for(int k=0; k<minLen;k++){
            char c1 = w1.charAt(k);
            char c2 = w2.charAt(k);

            if(c1!=c2){
                return charOrder[c1-'a'] < charOrder[c2-'a'];
            }
        }    
        return len1<=len2;
    }
}