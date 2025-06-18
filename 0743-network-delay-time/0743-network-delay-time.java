class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int time[] : times) {
            adj[time[0]].add(new int[] { time[1], time[2] });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[k] = 0;
        pq.offer(new int[] { 0, k });

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int node = top[1];
            for (int[] neig : adj[node]) {
                int adjNode = neig[0];
                int wt = neig[1];
                if (d + wt < dis[adjNode]) {
                    dis[adjNode] = d + wt;
                    pq.offer(new int[] { dis[adjNode], adjNode });
                }
            }
        }
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, dis[i]);
        }
        return ans;
    }
}