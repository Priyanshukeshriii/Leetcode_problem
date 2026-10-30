class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private void generate_powerset(int[] nums,int idx, List<Integer> set){
        if(idx >= nums.length){
            ans.add(new ArrayList<>(set));
            return;
        }
        set.add(nums[idx]);
        generate_powerset(nums,idx+1,set);
        set.remove(set.size()-1);
        generate_powerset(nums,idx+1,set);
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> set = new ArrayList<>();
        generate_powerset(nums,0,set);
        return ans;
        
    }
}