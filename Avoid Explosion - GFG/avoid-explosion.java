//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

  public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int mix[][] = new int[n][2];
            int danger[][] = new int[m][2];

            for (int i = 0; i < n; i++) {
                s = br.readLine().trim().split(" ");
                mix[i][0] = Integer.parseInt(s[0]);
                mix[i][1] = Integer.parseInt(s[1]);
            }
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                danger[i][0] = Integer.parseInt(s[0]);
                danger[i][1] = Integer.parseInt(s[1]);
            }
            Solution soln = new Solution();

            ArrayList<String> ans = soln.avoidExlosion(mix, n, danger, m);

            for (String x : ans) ot.print(x + " ");
            ot.println();
        }

        ot.close();
    }

}
// Position this line where user code will be pasted.

// } Driver Code Ends


// User function Template for Java

class Solution {
    //this problem is base upon DSU(disjoint set union),
        //dsu has three function firstly, make the set and intialise the parent and
        //2nd function to find the set of parent and 
        //third one union function two set initialise same parent, 
        //as union funtion use path function comparison,
        //time complexity of this algo is O(n * m * log n)
    int parent[];
    
    ArrayList<String> avoidExlosion(int mix[][], int n, int danger[][], int m) {
        // Code Here
        ArrayList<String> ans = new ArrayList<>();
        
        parent = new int [n+1]; 
        for(int i=0; i<=n; i++) parent[i]=i;
        
        //logic of code
        for(int j=0;j<n; j++){
            int a = find(mix[j][0]), b = find(mix[j][1]);
            // a and b give representive
            
            boolean canMix = true;
            
            for(int i =0; i<m; i++){
                int c = find(danger[i][0]), d= find(danger[i][1]);
                // c and d also give representive of their respective set
                //now compare a,b,c,d to find if they canMix or not
                if((a== c && b == d)|| (a==d && b ==c)){
                    canMix= false;
                    break;
                }
            }
            if(canMix){
                //if canMix is true we can form union 
                union(a,b); ans.add("Yes");
            }
            else {
                ans.add("No");
            }
        }
        
        return ans;
    }
    
    void union(int x, int y){
        
        int x_rep = find(x), y_rep = find(y);
        if(x_rep == y_rep) return;
        parent[x_rep] = y_rep;
    }
    
    //it return representive of set
    int find(int x){  //Time Complexity of find=: O[log(n)]
        if(parent[x]==x) return x;
        return find(parent[x]);
    }
}
