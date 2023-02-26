//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int v,e;
    int visit[];
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        //here Adjacency list is given
        //visited array in DFS graph
     visit= new int[V+1];
     int ans=0;
     for(int i=1;i<=V;i++){
         if(visit[i]!=1){
             v=0;
             e=0;
             DFS(i,adj);
             if(e == v*(v-1)) ans++;
            
         }
     }
       return ans;
    }
    //DFS function
    void DFS(int source, ArrayList<ArrayList<Integer>> adj){
        visit[source]=1;
        v++;
        for(int child: adj.get(source)){
            if(visit[child] != 1){
                DFS(child,adj);
            }
            e++;
        }
    }
}