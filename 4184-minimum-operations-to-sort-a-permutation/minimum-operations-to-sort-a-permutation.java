class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int drops = 0;
        int rises = 0;
        int pos0 = -1;

        // Check the array as a circle and locate '0'
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) pos0 = i;
            
            int next = (i + 1) % n;
            if (nums[i] > nums[next]) drops++;
            if (nums[i] < nums[next]) rises++;
        }

        // If it's scrambled and cannot be sorted
        if (drops > 1 && rises > 1) {
            return -1;
        }

        int minOps = Integer.MAX_VALUE;

        // CASE 1: Array is Cyclic Ascending (e.g., [3, 4, 0, 1, 2] or [1, 2, 3, 4, 0])
        if (drops <= 1) {
            // Option A: Just rotate left until 0 is at the front
            int opsA = pos0;
            
            // Option B: Reverse -> Rotate Left -> Reverse (Simulates right rotations)
            // (If pos0 is already 0, it takes 0 ops, not 2 ops)
            int opsB = (pos0 == 0) ? 0 : 2 + (n - pos0);
            
            minOps = Math.min(minOps, Math.min(opsA, opsB));
        }

        // CASE 2: Array is Cyclic Descending (e.g., [2, 1, 0, 4, 3])
        if (rises <= 1) {
            // Option C: Rotate Left until it's perfectly descending, THEN Reverse
            // To be perfectly descending, 0 must be at the very end (index n-1).
            int opsC = ((pos0 + 1) % n) + 1; // +1 is for the reverse operation
            
            // Option D: Reverse FIRST (becomes ascending), THEN Rotate Left
            // After reverse, 0 moves to index (n - 1 - pos0).
            // We then need exactly that many left rotations to put it at index 0.
            int opsD = 1 + (n - 1 - pos0);
            
            minOps = Math.min(minOps, Math.min(opsC, opsD));
        }

        return minOps;
    }
}