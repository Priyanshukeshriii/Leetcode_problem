class Solution {
    public int partition(String s, int l, int r) {

        int count = 0;

        for (int i = l; i < r; i++) {

            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                return i;
            }
        }

        return -1;
    }

    // Divide
    public int divide(String s, int l, int r) {

        // Empty string
        if (l >= r) {
            return 0;
        }

        // Find the end of first primitive group
        int p = partition(s, l, r);

        // Merge
        return merge(s, l, p, r);
    }

    // Merge the scores of A and B
    public int merge(String s, int l, int p, int r) {
        int leftScore;

        // If group is exactly ()
        if (p == l + 1) {
            leftScore = 1;
        } else {
            // Remove outer parentheses
            leftScore = 2 * divide(s, l + 1, p);
        }

        // If there is another group B
        if (p + 1 < r) {
            int rightScore = divide(s, p + 1, r);

            return leftScore + rightScore;
        }

        return leftScore;
    }

    public int scoreOfParentheses(String s) {
        if ((s.length() & 1 )== 1) return 0;
        return divide(s, 0, s.length());
    }
}