class Solution {
    public boolean check(int[] nums) {
        int size = nums.length;
        int idx = size - 1;
        while(idx > 0 && nums[idx-1] <= nums[idx]){
            idx--;
        }
        
        if (idx == 0)  return true;
        for(int i = idx ; i < (size + idx) - 1 ; i++){
            if((nums[(i) % size] > nums[(i + 1) % size])){
                return false;
            }
        } 
        return true;
    }
}