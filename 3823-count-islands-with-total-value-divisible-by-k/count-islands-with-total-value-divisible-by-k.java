class Solution {
    private int[][] grid;
    private int m , n;
    private long sum;
    private boolean isIsland(int i , int j){
        if(i<0 || i >= m || j < 0 || j >= n) return true;
        if(grid[i][j] == 0) return true;
        sum += grid[i][j];
        grid[i][j] = 0;
        isIsland(i+1,j);
        isIsland(i-1,j);
        isIsland(i,j+1);
        isIsland(i , j-1);
        return true;
    }
    public int countIslands(int[][] grid, int k) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int count = 0 ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                sum = 0;
                if(grid[i][j] != 0 ){
                    isIsland(i,j);
                    if(sum % (long)k == 0 )  count++;
                }
            }
        }
        return count;
    }
}