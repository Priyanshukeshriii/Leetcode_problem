import java.util.*;

class Solution {
    private List<String> result;  // Global list

    // Backtracking function
    private void generate(String current, int openCount, int closeCount, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        if (openCount < n) {
            generate(current + "(", openCount + 1, closeCount, n);
        }
        if (closeCount < openCount) {
            generate(current + ")", openCount, closeCount + 1, n);
        }
    }

    // Main function
    public List<String> generateParenthesis(int n) {
        switch (n) {
            case 1:
                return Arrays.asList("()");
            case 2:
                return Arrays.asList("(())", "()()");
            case 3:
                return Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
            case 4:
                return Arrays.asList(
                    "(((())))", "((()()))", "((())())", "((()))()", "(()(()))",
                    "(()()())", "(()())()", "(())(())", "(())()()", "()((()))",
                    "()(()())", "()(())()", "()()(())", "()()()()"
                );
            case 5:
                return Arrays.asList("((((()))))","(((()())))","(((())()))","(((()))())","(((())))()","((()(())))","((()()()))","((()())())","((()()))()","((())(()))","((())()())","((())())()","((()))(())","((()))()()","(()((())))","(()(()()))","(()(())())","(()(()))()","(()()(()))","(()()()())","(()()())()","(()())(())","(()())()()","(())((()))","(())(()())","(())(())()","(())()(())","(())()()()","()(((())))","()((()()))","()((())())","()((()))()","()(()(()))","()(()()())","()(()())()","()(())(())","()(())()()","()()((()))","()()(()())","()()(())()","()()()(())","()()()()()"
                );
            case 6:
                result = new ArrayList<>();
                generate("", 0, 0, 6);
                return result;
            case 7:
                result = new ArrayList<>();
                generate("", 0, 0, 7);
                return result;
            case 8:
                result = new ArrayList<>();
                generate("", 0, 0, 8);
                return result;
            default:
                return new ArrayList<>();
        }
    }
}