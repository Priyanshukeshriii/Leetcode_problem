class Solution {
    public int minimizeSum(int[] nums) {
        if (nums.length == 3) return 0;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, Math.abs(nums[1] - nums[nums.length -2]));
        ans = Math.min(ans, Math.abs(nums[2] - nums[nums.length-1]));
        ans = Math.min(ans, Math.abs(nums[0] - nums[nums.length-3]));
        return ans;
    }
}