class Solution {
    public int missingNumber(int[] nums) {
        int n_xor =0;
        int nums_xor = 0;
        for(int i = 0 ; i<nums.length ; i++){
            nums_xor ^= nums[i];
            n_xor ^= i+1;  
        }
        return n_xor ^ nums_xor;
        
    }
}