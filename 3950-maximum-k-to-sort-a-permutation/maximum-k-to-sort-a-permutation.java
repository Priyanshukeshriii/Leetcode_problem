class Solution {
    public int sortPermutation(int[] nums) {
        if(nums[0]!=0) return 0;
        int ans=0;
        boolean set = true;
        for(int i =0;i<nums.length;i++){
            if(!(nums[i]==i)){
                if(ans==0 && set){
                    ans =nums[i];
                    set = false;
                }    
                ans=ans&nums[i];
            }
        }
        return ans;
    }
}