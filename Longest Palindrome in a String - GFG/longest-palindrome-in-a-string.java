//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String s){
        // code here
        //we are solving this using left and right pointer 
        // in even condition skip middle duplicate element and move right pointer and check for palindrome
        
        int n = s.length();
        String ans = "";
        
        for(int i=0; i<n; i++){
            int leftp = i-1;
            int rightp = i;
            String str ="";
            str += s.charAt(i);
            //skip the middle duplicate if have
            while(i<n-1 && s.charAt(i)==s.charAt(i+1))  str = str+s.charAt(i++);
                rightp = i+1;
            
            
            
            //Check for the palindrome
            while(leftp>=0 && rightp<n && s.charAt(rightp)==s.charAt(leftp)){
                str = str+s.charAt(rightp++);
                str = s.charAt(leftp--)+str;
        
            }
            if(str.length()>ans.length()) ans=str;
        }
        
        return ans;
        
        
    }
}