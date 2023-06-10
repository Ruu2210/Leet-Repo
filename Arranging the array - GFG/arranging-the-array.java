//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.Rearrange(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void Rearrange(int arr[], int n)
    {
        // Your code goes here
        //we are solving using stack
        Stack<Integer>st = new Stack<>();
        int j=0;
        for(int i=0; i<n; i++){
            //place negative element as it is in stack 
            if(arr[i]<0) arr[j++]=arr[i];
            else st.push(arr[i]);
            
        }
        j = n-1;
        
        while(!st.empty()){
            //maintaning order of all -ve and non -ve numbers as in origin array
            arr[j--] = st.pop();
        }
        
    }
}