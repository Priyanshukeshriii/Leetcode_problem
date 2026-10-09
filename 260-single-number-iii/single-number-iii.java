class Solution {
    public int[] singleNumber(int[] nums) {
        int box1 = 0;
        int box2 = 0;
        int xor= 0;
        for(int num: nums){
            xor ^= num;
        }
        int lastSetBit= xor & (-xor);
        for(int num : nums){
            if((num & lastSetBit) != 0){
                box1 ^= num;
            }else  box2 ^= num;
        }
        return new int[]{box1,box2};
    }
}