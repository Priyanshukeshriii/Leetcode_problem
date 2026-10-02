class Solution {
    public void moveZeroes(int[] nums) {
        int z_idx = -1; 
        for(int i = 0 ; i < nums.length ; i++){
            if(z_idx ==-1 && nums[i] == 0){
                z_idx = i;
            }else if((z_idx !=-1 && nums[i] != 0)){
                nums[z_idx] = nums[i];
                nums[i] = 0;
                z_idx++;
            }
        }
    }
}