class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int bit_idx = 0 ; bit_idx < 32 ; bit_idx++){
            int count = 0;
            for(int i = 0 ; i < nums.length; i++){
                if((nums[i] & (1 << bit_idx)) != 0){
                    count++;
                }
            }
            if((count % 3 )== 1 ){
                ans = ans | (1<<bit_idx);
            }
        }
        return ans;
    }
}