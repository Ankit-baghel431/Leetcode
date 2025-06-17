class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> res=new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge:prerequisites){
            int u=edge[1];
            int v=edge[0];
            adj.get(u).add(v);
        }
        int[] indegree=new int[numCourses];
        for(int u=0;u<numCourses;u++){
            for(int v:adj.get(u)){
                indegree[v]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            res.add(curr);
            for(int neig:adj.get(curr)){
                indegree[neig]--;
                if(indegree[neig]==0){
                    q.add(neig);
                }
            }
        }
        if(res.size() == numCourses) return true;
        return false;
    }
}