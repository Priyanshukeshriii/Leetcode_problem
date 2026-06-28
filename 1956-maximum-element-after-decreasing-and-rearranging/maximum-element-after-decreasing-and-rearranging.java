class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int size = arr.length;
        int[] freq = new int[size +1];
        for(int num : arr){
            freq[Math.min(num,size)]++;
        }
        int ans = 0;
        for(int i = 1 ; i<=size ; i++){
            ans = Math.min(i , ans + freq[i]);
        }
        return ans;
    }
}