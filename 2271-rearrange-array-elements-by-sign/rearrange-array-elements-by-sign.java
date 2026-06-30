class Solution {
    public int[] rearrangeArray(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];
        int i = 0; 
        int j = 1; 
        int k = 0;
        while(k < size){
            if(nums[k] > 0){
                ans[i] = nums[k];
                i += 2;
            }else{
                ans[j] = nums[k];
                j += 2;
            }
            k++;
        }
        return ans;
    }
}