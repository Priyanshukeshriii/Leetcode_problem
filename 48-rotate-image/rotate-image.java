class Solution {
    public void rotate(int[][] mat) {
        int m = mat.length;
        // transpose the matrix
        for(int i = 0 ; i < m-1 ; i++){
            for(int j = 1 +i; j < m ; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        // revers the rows of matrix
        for(int i = 0 ; i < m ; i++){
            int j = 0;
            int k = m -1;
            while(j < k){
                int temp = mat[i][j];
                mat[i][j] = mat[i][k];
                mat[i][k] = temp;
                k--;
                j++;
            }
        }
    }
}