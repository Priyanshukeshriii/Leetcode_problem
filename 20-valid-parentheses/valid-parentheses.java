

class Solution {
    public boolean isValid(String s) {
        if (s == null || (s.length() % 2) == 1) return false; // odd length can't be valid

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else {
                // ch is a closing bracket: check match
                if (stack.isEmpty() || stack.pop() != ch) return false;
            }
        }

        return stack.isEmpty();
    }
}