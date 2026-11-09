
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        int[] count = new int[k];

        // Stores {finishingTime, serverId}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // Stores available server IDs
        TreeSet<Integer> available = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {

            // Release servers that have completed their tasks
            while (!pq.isEmpty() &&
                   pq.peek()[0] <= arrival[i]) {

                int[] completed = pq.poll();
                available.add(completed[1]);
            }

            if (available.isEmpty()) {
                continue;
            }

            int preferred = i % k;

            // Find the next available server
            Integer server = available.ceiling(preferred);

            // Wrap around if necessary
            if (server == null) {
                server = available.first();
            }

            available.remove(server);

            count[server]++;

            pq.offer(new int[]{
                arrival[i] + load[i],
                server
            });
        }

        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}
