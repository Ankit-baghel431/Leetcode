class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<n*m;i++){
            pq.add(matrix[i/m][i%m]);
        }
        for(int i = 0;i<k-1;i++){
            pq.poll();
        }
        int ans = pq.peek();
        return ans;
    }
}