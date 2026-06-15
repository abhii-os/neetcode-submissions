class Solution {
    public String minWindow(String s, String t) {
        if(s==null||t==null || s.length() < t.length()){
            return "";
        }
        Map<Character, Integer> targetMap = new HashMap<>();
        for(char c: t.toCharArray()){
            targetMap.put(c,targetMap.getOrDefault(c,0)+1);
        }

        Map<Character, Integer> cart = new HashMap<>();
        int left = 0;
        int right = 0;
        int formedUniqueChars = 0;
        int requiredUniqueChars = targetMap.size();

        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;


        while(right<s.length()){
            char r = s.charAt(right);
            cart.put(r, cart.getOrDefault(r,0)+1);

            if(targetMap.containsKey(r) && cart.get(r).equals(targetMap.get(r))){
                formedUniqueChars++ ;
            }
            while(left<=right && formedUniqueChars == requiredUniqueChars){
                if(right-left+1<minLen){
                    minLen = right-left+1;
                    minLeft = left;
                }
                char l = s.charAt(left);
                cart.put(l,cart.get(l)-1);

                if(targetMap.containsKey(l) && cart.get(l)<targetMap.get(l)){
                    formedUniqueChars--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "":s.substring(minLeft,minLeft+minLen);
    }
}
