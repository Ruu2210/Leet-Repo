//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int uniquePaths(int r, int c, int[][] grid) {
        // code here
        int mod = 1000000007;
        //check if start or end is 0 or not
        if(grid[0][0]==0 || grid[r-1][c-1]==0){
            return 0;
        }
        // create dp array 
        int [][]dp = new int[r][c];
       // dp[0][0]= grid[0][0]%mod;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 0) dp[i][j]=0;
                else if(i==0 && j==0) dp[i][j]=1;
                else if(i==0 ) dp[i][j]= dp[i][j-1];
                else if(j==0) dp[i][j]= dp[i-1][j];
                else dp[i][j]=(dp[i-1][j]+dp[i][j-1])%mod;
            }
        }
        return dp[r-1][c-1];
        
    }
}