class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int [] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int [] b : flights){
            int u = b[0];
            int v = b[1];
            int cost = b[2];
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, cost});
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        distance[src] = 0;
        int level = 0;

        while (!queue.isEmpty() && level <= k) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int u = current[0];
                int d = current[1];

                List<int[]> neighbors = adj.getOrDefault(u, Collections.emptyList());
                for (int[] neighbor : neighbors) {
                    int v = neighbor[0];
                    int cost = neighbor[1];

                    if (distance[v] > d + cost) {
                        distance[v] = d + cost;
                        queue.offer(new int[]{v, d + cost});
                    }
                }
            }
            level++;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}