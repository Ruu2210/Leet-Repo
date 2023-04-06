//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int addMinChar(String str){
		//code here
		if(isP(str)) return 0;
		int i=0;
		int j=str.length()-1;
		while(i<j){
		    if (str.charAt(j) != str.charAt(i) && str.charAt(j) != str.charAt(0)) {
                i = 0;
                j--;
            } else if (str.charAt(j) != str.charAt(i) && str.charAt(j) == str.charAt(0)) {
                i = 1;
                j--;
            } else {
                i++;
                j--;
            }
		}
		if(i==0){
		    return (str.length()-1);
		}
		if(i==j){
		    int correct = 2*(i) + 1;
		    return (str.length()-correct);
		}else{
		    int correct = 2*(i);
		    return (str.length()-correct);
		}
		
	}
	static boolean isP(String str){
	    int i=0;
	    int j=str.length()-1;
	    while(i<j){
	        if(str.charAt(i) == str.charAt(j)){
	            
	        }else{
	            return false;
	        }
	        i++;
	        j--;
	    }
	    return true;
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
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends