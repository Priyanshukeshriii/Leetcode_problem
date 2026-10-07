class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();

        int leftRemove = 0;
        int rightRemove = 0;

        // Find the minimum number of '(' and ')' to remove
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                leftRemove++;
            } 
            else if (s.charAt(i) == ')') {

                if (leftRemove > 0) {
                    leftRemove--;
                } 
                else {
                    rightRemove++;
                }
            }
        }

        solve(s, 0, 0, leftRemove, rightRemove,
              new StringBuilder(), ans);

        return ans;
    }

    private void solve(
        String s,
        int index,
        int balance,
        int leftRemove,
        int rightRemove,
        StringBuilder current,
        List<String> ans
    ) {

        if (index == s.length()) {

            if (balance == 0 &&
                leftRemove == 0 &&
                rightRemove == 0) {

                String result = current.toString();

                if (!ans.contains(result)) {
                    ans.add(result);
                }
            }

            return;
        }
        char ch = s.charAt(index);
        if (ch == '(') {
            if (leftRemove > 0) {

                solve(
                    s,
                    index + 1,
                    balance,
                    leftRemove - 1,
                    rightRemove,
                    current,
                    ans
                );
            }
            current.append('(');
            solve(
                s,
                index + 1,
                balance + 1,
                leftRemove,
                rightRemove,
                current,
                ans
            );
            current.deleteCharAt(current.length() - 1);
        }

        else if (ch == ')') {
            if (rightRemove > 0) {
                solve(
                    s,
                    index + 1,
                    balance,
                    leftRemove,
                    rightRemove - 1,
                    current,
                    ans
                );
            }
            if (balance > 0) {
                current.append(')');
                solve(
                    s,
                    index + 1,
                    balance - 1,
                    leftRemove,
                    rightRemove,
                    current,
                    ans
                );

                current.deleteCharAt(current.length() - 1);
            }
        }
        else {
            current.append(ch);
            solve(
                s,
                index + 1,
                balance,
                leftRemove,
                rightRemove,
                current,
                ans
            );
            current.deleteCharAt(current.length() - 1);
        }
    }
}

