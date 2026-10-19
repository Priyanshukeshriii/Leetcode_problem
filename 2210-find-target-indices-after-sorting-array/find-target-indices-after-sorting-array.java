class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int s = 0;
        int e = 0;
        List<Integer> ans = new ArrayList<>();
        for(int n : nums){
            if(n < target) s++;
            if(n == target) e++;
        }
        int i = 0;
        while(i < e){
            ans.add(s+i);
            i++;
        }
        return ans;
    }
}