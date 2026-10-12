class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long ans = 0; 
        long curr;    
        int mod = 1000000007;
        int[] bits = new int[32];
        
        for(int a : nums){
            for(int i = 0 ; i < 32; i++){
                if((a & (1<<i)) != 0){
                    bits[i]++;
                }
            }
        }
        
        for(int j = 0 ; j < k ; j++){
            curr = 0;
            for(int i = 0; i < 32 ; i++){
                if(bits[i] > 0){
                    bits[i]--;
                    curr += 1 << i;
                }
            }
            // Modulo applied to the squared term AND the total sum
            ans = (ans + (curr * curr) % mod) % mod; 
        }
        
        return (int) ans; 
    }
}