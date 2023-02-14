//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] col, int N){
        //Write your code here
        
        //make dp array
        int dp[][]= new int [N][3]; //bcoz we have 3 colors
        
        //now fill 1st row of dp with 1st column of colors
        dp[0][0] =col[0][0];
        dp[0][1] = col[0][1];
        dp[0][2] = col[0][2];
        
        // now fill remaining dp  array with help of previous one
        for(int i=1;i<N;i++){
            //as 1st column of array is already filled we start with dp[1][0]
            //and comparing current one with previous values
            dp[i][0]=col[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            //in above step we are filling 2nd column 1st row so for previous value checking 
            //we check for remaining 2 two rows
            dp[i][1]=col[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=col[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
            
        }
        //now return minimum value of last cell (which is our exact answer)
        
        return Math.min(Math.min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]);
    }
        
    }
