class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int flag = -1;
        int max = 0;
        int g_max = 0;
        for(int i =0 ; i < nums.length -1; i++){
            if(nums[i] == nums[i+1]) flag = -1;
            if(nums[i] > nums[i+1]){
                if(flag != 1){
                    flag =1;
                    max = 1;
                }
                max++;
            }
            if(nums[i] < nums[i+1]){
                if(flag != 0){
                    flag =0;
                    max = 1;
                }
                max++;
            }
            g_max = Math.max(g_max , max);
            
        }
        return g_max > 0 ? g_max : 1;
    }
}