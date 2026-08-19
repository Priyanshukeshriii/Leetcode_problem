class Solution {
    public int maxNumberOfFamilies(int n, int[][] rs) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        // Store reserved seats row-wise
        for (int[] r : rs) {
            map.computeIfAbsent(r[0], x -> new HashSet<>()).add(r[1]);
        }

        // Rows with no reservations can accommodate 2 families
        int ans = (n - map.size()) * 2;

        // Process only rows that have reservations
        for (Set<Integer> seats : map.values()) {

            boolean left = true;    // 2,3,4,5
            boolean middle = true;  // 4,5,6,7
            boolean right = true;   // 6,7,8,9

            for (int seat : seats) {

                if (seat >= 2 && seat <= 5)
                    left = false;

                if (seat >= 4 && seat <= 7)
                    middle = false;

                if (seat >= 6 && seat <= 9)
                    right = false;
            }

            if (left)
                ans++;

            if (right)
                ans++;

            if (!left && !right && middle)
                ans++;
        }

        return ans;
    }
}