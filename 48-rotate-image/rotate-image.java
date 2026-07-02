class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;
        int k = n -1;
        for(int i = 0 ; i < n/2 ; i++){
            for(int j = i ; j <k-i;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[k-j][i];
                mat[k-j][i]= mat[k-i][k-j];
                mat[k-i][k-j] = mat[j][k-i];
                mat[j][k-i]= temp;
            }
        }
    }
}