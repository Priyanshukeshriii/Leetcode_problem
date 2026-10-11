class Solution {
    public int sumOfSquares(int[] nums) {
        int sum = 0;
        int n = nums.length;
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += nums[i - 1] * nums[i - 1];
                int sec_i = n / i;
                if (i != sec_i) {
                    sum += nums[sec_i - 1] * nums[sec_i - 1];
                }
            }
        }
        return sum;
    }
}