class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int topoArr[] = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int pre[] : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        int endegree[] = new int[numCourses];
        for (int u = 0; u < numCourses; u++) {
            for (int v : adj.get(u)) {
                endegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (endegree[i] == 0) {
                q.add(i);
            }
        }
        int index = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            topoArr[index++] = curr;
            for (int neig : adj.get(curr)) {
                endegree[neig]--;
                if (endegree[neig] == 0) {
                    q.add(neig);
                }
            }
        }
        if (index == numCourses)
            return topoArr;
        int[] arr = {};
        return arr;
    }
}