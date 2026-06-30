class Solution {
    public void reverse(int[] nums , int i , int j){
        
        while(i < j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
        
    }
    public void nextPermutation(int[] nums) {
        int idx = -1;
        int size= nums.length;
        for(int i = size -1 ; i>0 ; i--){
            if(nums[i] > nums[i-1]){
                idx = i-1;
                break;
            }
        }
        if(idx == -1){
            reverse(nums , 0 , nums.length -1);
            return;
        }
        
        for(int i = size -1; i > idx ; i--){
            if(nums[idx] < nums[i]){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        reverse(nums , idx+1, nums.length-1);
        return;

    }
}