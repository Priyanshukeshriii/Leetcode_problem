class Solution {
    public int firstStableIndex(int[] arr, int t) {
        int size = arr.length;
        int max =-1;
        int min = Integer.MAX_VALUE;
        int[] suffix_min = new int[size];
        for(int i = size - 1 ; i >=0; i--){
            if (arr[i] < min) min = arr[i];
            suffix_min[i] = min;
        }
        for(int i = 0; i < size ; i++){
            max = Math.max(max,arr[i]);
            
            
            if(max - suffix_min[i] <= t){
                
                return i;
            }
        }
        return -1;
    }
}