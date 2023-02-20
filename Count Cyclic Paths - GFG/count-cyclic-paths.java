//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
	public static int countPaths(int N){
		//code here
		if(N<2) return 0;
		long m= 1000000007;
		long t=0; //total number of steps
		int i=2; // bcoz minimum 2 steps required 
		while(i<=N){
		    t=(t*3)%m; //every step generate 3 more steps
		    if(i%2!=0) t-=3; //if t is odd
		    else t= (t+3)%m;
		    i++;
		    
		}
		return (int)t;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends