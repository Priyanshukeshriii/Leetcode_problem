class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        StringBuilder first = new StringBuilder();
        for (int j = 0; j < n; j++) {
            first.append('.');
        }
        grid[0] = first.toString();

        StringBuilder second = new StringBuilder();
        for (int j = 0; j < n - 1; j++) {
            second.append('#');
        }
        second.append('.');

        for (int i = 1; i < m; i++) {
            grid[i] = second.toString();
        }

        return grid;
    }
}