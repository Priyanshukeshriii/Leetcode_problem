class Solution {
public:
    int sumCounts(vector<int>& nums) {
        int n = nums.size();
        int ans = 0;
        
        for (int l = 0; l < n; l++) {
            bitset<101> seen; 
            int cnt = 0;
            
            for (int r = l; r < n; r++) {
                int x = nums[r];
                if (seen[x] == 0) {
                    cnt++;
                    seen[x] = 1;
                }
                ans += cnt * cnt;
            } 
        }
        return ans;
    }
};