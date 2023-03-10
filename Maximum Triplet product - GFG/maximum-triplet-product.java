//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    // Long maxTripletProduct(Long arr[], int n)
    // {
    //     // Complete the function
    // Arrays.sort(arr); // Sort the array in non-decreasing order
    // // Compute product of last three elements
    // Long product1 = arr[n-1] * arr[n-2] * arr[n-3]; 
    // // Compute product of first two and last element
    // Long product2 = arr[0] * arr[1] * arr[n-1]; 
    // return Math.max(product1, product2); // Return the maximum of the two products
    // }
    
   
    Long maxTripletProduct(Long arr[], int n)
    {
       long m1 =Long.MIN_VALUE;
       long m2 = Long.MIN_VALUE; 
       long m3 = Long.MIN_VALUE;
       long s1 =Long.MAX_VALUE; 
       long s2 = Long.MAX_VALUE;
       
       for(long i : arr){
           //max
           if(i> m1){
               m3 = m2;
               m2 = m1;
               m1 = i;
               
           }else if(i>m2){
                   m3 = m2;
                   m2 = i; 
            }else if(i>m3){
                m3 = i;
            }
           
           //smallest
           if(i<s1){
               s2 = s1;
               s1 = i;
           }else if(i<s2){
               s2 = i;
           }
       }
       
       return (long) Math.max((m1*m2*m3) , (m1*s1*s2));
    }

    
    
    
    
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    Long[] arr = new Long[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Long.parseLong(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    Long res = obj.maxTripletProduct(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends