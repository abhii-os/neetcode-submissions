class Solution {
    public int lengthOfLongestSubstring(String s) {
         int left = 0, right = 0, maxLength = 0;
        HashSet<Character> seen = new HashSet<>();

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (!seen.contains(currentChar)) {
                seen.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                seen.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }
    }