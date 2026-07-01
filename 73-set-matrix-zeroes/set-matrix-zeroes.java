class Solution {
    // Set an entire row to 0
    public void setHorizontal(int[][] mat, int row, int n) {
        for (int j = 0; j < n; j++) {
            mat[row][j] = 0;
        }
    }

    // Set an entire column to 0
    public void setVertical(int[][] mat, int col, int m) {
        for (int i = 0; i < m; i++) {
            mat[i][col] = 0;
        }
    }    
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean h = false;
        boolean v = false;
        for(int i = 0 ; i < m ; i ++){
            for(int j = 0  ; j < n ; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if(i==0) v= true;
                    if(j ==0 ) h= true;
                }
            }
        }
        for(int i = 1 ; i < n ; i++){
            if(matrix[0][i] == 0){
                setVertical(matrix , i ,m);
            }
        }
        for(int i = 1 ; i < m ; i++){
            if(matrix[i][0] == 0){
                setHorizontal(matrix , i ,n);
            }
        }
        if(matrix[0][0] == 0){
            if(h) setVertical(matrix , 0 ,m);
            if(v)setHorizontal(matrix , 0 ,n);
        }
    }
}