class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        int ans = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            if (sum == k) {
                ans++;
            }

            if (prefixSum.containsKey(sum - k)) {
                ans += prefixSum.get(sum - k);
            }

            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}