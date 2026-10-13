class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int h = n / 2; 
        
        
        int[] counts = new int[40001];
        for (int num : nums) {
            counts[Math.abs(num)]++;
        }
        
        long ans = 0;
        int subtractedCount = 0;
        
        
        for (int i = 0; i <= 40000; i++) {
            while (counts[i] > 0) {
                
                if (subtractedCount < h) {
                    ans -= (long) i * i;
                    subtractedCount++;
                } 
                
                else {
                    ans += (long) i * i;
                }
                counts[i]--;
            }
        }
        
        return ans;
    }
}