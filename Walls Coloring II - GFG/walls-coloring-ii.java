//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] costs) {
		//Write your code here
		//it is same like previous one just here color size is not fixed
		int N = costs.length;
		int K = costs[0].length; //length of 0th row 
		
		int dp [] [] = new int [N][K];
		
		if(N>1 && K==1) return -1; //no. of colors< no. of walls
		
		// fill first row with first row of costs
		
		int m1 = Integer.MAX_VALUE; 
		int m2 = Integer.MAX_VALUE; 
		//2 Pointers for storing previous min count
		
		for(int i=0 ;i<K; i++){
		//filled pointer at 1st row     
		    dp[0][i]=costs[0][i];
		    // no two adjacent walls have the same color.so compare with if min is == current value
		    if(costs[0][i]< m1) {
		        m2 = m1;
		        m1 = costs[0][i];
		    }
		    else if(costs[0][i] < m2){
		        m2 = costs[0][i];
		    }
		}
		//we find m1 and m2 for 1st row
		
		
		//Now iterate for next rows (here m1 and m2 will change)
		
		int cm1 = Integer.MAX_VALUE;
		int cm2 = Integer.MAX_VALUE;
		
		for(int itra =1; itra <N; itra++)
		{
		    for(int i=0;i<K;i++)
		    {
		    //addtion in next row
		    if(dp[itra-1][i] ==  m1) dp[itra][i] = costs[itra][i]+m2;
		    else dp[itra][i] = costs[itra][i]+m1;
		    
		    //Now update m1 and m2 for next itration
            if(dp[itra][i]< cm1){
                cm2 = cm1;
                cm1 = dp[itra][i];
            }		    
            else if (dp[itra][i] < cm2){
                cm2 = dp[itra][i];
            }
		  }
		
		//after row where each column is filled , now swap pointers for next row
		
		m1 = cm1;
		m2 = cm2;
		
		cm1 = Integer.MAX_VALUE;
		cm2 = Integer.MAX_VALUE;
		
		}
	
	return m1; //which pointing minimum value in last row 
   }
}