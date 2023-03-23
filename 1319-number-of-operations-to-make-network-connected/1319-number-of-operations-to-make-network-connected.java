class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
            return -1;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        boolean vis[]=new boolean[n];
        Queue<Integer> qu=new LinkedList<>();
        qu.add(0);
        int comp=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,vis,adj);
                comp++;
            }
        }
        return comp-1;
    }
    public void bfs(int node,boolean[] vis,List<List<Integer>> adj){
        Queue<Integer> qu=new LinkedList<>();
        qu.add(node);
        while(!qu.isEmpty()){
            int curr=qu.poll();
            for(int adjnode:adj.get(curr)){
                if(!vis[adjnode]){
                    qu.add(adjnode);
                    vis[adjnode]=true;
                }
            }
        }
    }
}