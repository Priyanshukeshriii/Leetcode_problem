class Solution {
    static{
        Solution s = new Solution();
        for(int i = 0 ; i < 5 ; i++) s.createGrid(2,2);
    }
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append('.');
        }
        grid[0] = sb.toString();
        sb = new StringBuilder();
        for (int j = 0; j < n - 1; j++) {
            sb.append('#');
        }
        sb.append('.');

        for (int i = 1; i < m; i++) {
            grid[i] = sb.toString();
        }

        return grid;
    }
}