class Solution {
    int [] parent;
    int [] rank;
    public void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX == parentY){
            return;
        }
        int rankX = rank[parentX];
        int rankY = rank[parentY];
        if(rankX > rankY){
            parent[parentY] = parentX;
        }
        else if(rankX < rankY){
            parent[parentX] = parentY;
        } 
        else {
            parent[parentX] = parentY;
            rank[parentY]++;
        }
    }
    public int find(int x){
        if(x == parent[x]) return parent[x];
        return parent[x] = find(parent[x]);
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        rank = new int[n];
        for(int i =0;i<n;i++){
            parent[i] = i;
        }
        for(int [] edge : edges){
            int x = edge[0];
            int y = edge[1];
            union(x,y);
        }
        int src = find(source);
        int dest = find(destination);
        return src == dest;
    }
}