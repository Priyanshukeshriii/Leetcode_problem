class Solution {
    public int firstStableIndex(int[] arr, int t) {
        int index = -1;
        int size = arr.length;
        int max =-1;
        int[] suffix_min = new int[size];
        suffix_min[size-1] = arr[size-1];
        for(int i = size - 2 ; i >=0; i--){
            suffix_min[i] = Math.min(suffix_min[i+1],arr[i]);
        }
        for(int i = 0; i < size ; i++){
            max = Math.max(max,arr[i]);
            
            int temp = Math.abs(max - suffix_min[i]);
            if(temp <= t){
                index = i;
                return index;
            }
        }
        return index;
    }
}