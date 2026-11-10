class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int j = 1; j <= costs.length ;j++){
            int i = 1;
            dp[j]=Integer.MAX_VALUE;
            while(j-i >= 0 && i <= 3){
                dp[j]= Math.min(dp[j],dp[j-i]+ costs[j-1] + i*i);
                i++;
            }
        }
        return dp[n];
    }
}