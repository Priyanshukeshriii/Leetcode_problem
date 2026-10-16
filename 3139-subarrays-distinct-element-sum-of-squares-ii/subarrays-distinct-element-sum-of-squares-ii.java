class Solution {
    private static final int MOD = 1_000_000_007;
    
    private long[] cnt;
    private long[] sqCnt;
    private long[] lazy;
    
    private void apply(int node, int st, int end, long x) {
        int len = end - st + 1;
        
        // (a + x)^2 = a^2 + 2*a*x + x^2
        // Must update sqCnt FIRST using the old cnt
        long xSqLen = (x * x % MOD) * len % MOD;
        long twoXCnt = (2 * x % MOD) * cnt[node] % MOD;
        
        sqCnt[node] = (sqCnt[node] + twoXCnt + xSqLen) % MOD;
        
        // Update normal sum: sum(a + x) = sum(a) + len * x
        cnt[node] = (cnt[node] + len * x) % MOD;
        
        // Accumulate lazy tag for child nodes
        lazy[node] = (lazy[node] + x) % MOD;
    }
    
    private void lazyPropagation(int node, int st, int end) {
        if (lazy[node] == 0) return;
        
        long x = lazy[node];
        int mid = st + (end - st) / 2;
        
        apply(2 * node, st, mid, x);
        apply(2 * node + 1, mid + 1, end, x);
        
        lazy[node] = 0; // Reset lazy tag after pushing down
    }
    
    private void merge(int node) {
        cnt[node] = (cnt[2 * node] + cnt[2 * node + 1]) % MOD;
        sqCnt[node] = (sqCnt[2 * node] + sqCnt[2 * node + 1]) % MOD;
    }
    
    private void update(int node, int st, int end, int ql, int qr) {
        // 1. No overlap
        if (qr < st || end < ql) return;
        
        // 2. Complete overlap
        if (ql <= st && end <= qr) {
            apply(node, st, end, 1);
            return;
        }

        // 3. Partial overlap: push lazy values down and recurse
        lazyPropagation(node, st, end);
        int mid = st + (end - st) / 2;
        
        update(2 * node, st, mid, ql, qr);
        update(2 * node + 1, mid + 1, end, ql, qr);
        
        merge(node);
    }
    
    public int sumCounts(int[] nums) {
        int n = nums.length;
        long ans = 0;
        
        // Initialize segment tree arrays for the current length
        cnt = new long[4 * n + 1];
        sqCnt = new long[4 * n + 1];
        lazy = new long[4 * n + 1];
        
        // Assuming values in nums are bounded by 10^5 per LeetCode constraints.
        // If values can be arbitrarily large, use a HashMap<Integer, Integer> instead.
        int[] lastSeen = new int[100005];
        Arrays.fill(lastSeen, -1);

        for (int i = 0; i < n; i++) {
            // Subarrays starting from 'st' to 'i' get a new distinct element
            int st = (lastSeen[nums[i]] == -1 ? 0 : lastSeen[nums[i]] + 1);
            lastSeen[nums[i]] = i;
            
            // Add 1 to the distinct count of all subarrays starting in [st, i]
            update(1, 0, n - 1, st, i);
            
            // sqCnt[1] holds the sum of squares for all subarrays ending at 'i'
            ans = (ans + sqCnt[1]) % MOD;
        }

        return (int) ans;
    }
}