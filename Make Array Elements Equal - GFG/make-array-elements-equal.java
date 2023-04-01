//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.minOperations(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long minOperations(int N) {
        // Code here
        long lastNo = 2*N-1;
        
        long diff = (lastNo-1)/2;
        
        long result=0;
        
        long n=0;
        
        if(diff%2 == 0){
            n = diff/2;
            result =  n*(n+1); 
            
        }
        else{
            n= (diff+1)/2;
            result= n*n;
        }
        return result;
        
        
          
    }
}