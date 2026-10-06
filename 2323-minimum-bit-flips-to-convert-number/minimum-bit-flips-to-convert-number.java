class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = 0;
        int setBit = start ^ goal;
        while(setBit>0){
            if((setBit & 1) == 1){
                ans++;
            }
            setBit =setBit>>1;
        }
        return ans;
    }
}