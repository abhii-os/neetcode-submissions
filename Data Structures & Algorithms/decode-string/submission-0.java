

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Form the multi-digit multiplier k
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push current multiplier and string state onto stacks
                countStack.push(k);
                stringStack.push(currentString);
                
                // Reset current state for the inner bracket
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Pop the string state before '[' and repeat currentString k times
                StringBuilder decodedString = stringStack.pop();
                int currentK = countStack.pop();
                
                for (int i = 0; i < currentK; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                // Regular character: append to current decoded string segment
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}