class Solution {
    public int sortPermutation(int[] nums) {
        int n=nums.length;
        int ans=(1<<17)-1;
        for(int i=0;i<n;i++){
            if(nums[i]==i) continue;
            ans&=nums[i];
        }
        return ans==((1<<17)-1)?0:ans;
    }
}