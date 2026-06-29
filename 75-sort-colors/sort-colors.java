class Solution {
    public void sortColors(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];
            int idx = i;

            while (idx > 0 && nums[idx - 1] > num) {
                nums[idx] = nums[idx - 1];
                idx--;
            }

            nums[idx] = num;
        }
    }
}