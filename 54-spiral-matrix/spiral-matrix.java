class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        List<Integer> ans = new ArrayList<>();

        int s = (Math.min(m.length, m[0].length) + 1) / 2;

        for (int i = 0; i < s; i++) {

            int j, k, l, n;

            // Top row
            for (j = i; j < m[0].length - i; j++) {
                ans.add(m[i][j]);
            }

            // Right column
            for (k = i + 1; k < m.length - i; k++) {
                ans.add(m[k][j - 1]);
            }

            // Bottom row
            if (k - 1 != i) {
                for (l = j - 2; l >= i; l--) {
                    ans.add(m[k - 1][l]);
                }
            } else {
                l = i - 1;
            }

            // Left column
            if (j - 1 != i) {
                for (n = k - 2; n > i; n--) {
                    ans.add(m[n][l + 1]);
                }
            }
        }

        return ans;
    }
}