class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        int unique = 1;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[idx] != nums[i]){
                unique++;
                nums[idx +1] = nums[i];
                idx++;
            }
        }
        return unique;
    }
}