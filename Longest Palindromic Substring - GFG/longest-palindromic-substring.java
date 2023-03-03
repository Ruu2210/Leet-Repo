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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public String longestPalindrome(String s) {
        String m=" ";
        int longestStr =0;
        
        for(int i=0;i<s.length();i++){
            
        //for even length 
        int L= i;
        int R= i+1;
        while(L>=0 && R<s.length() && s.charAt(L)==s.charAt(R)){
            //update longest String 
            if(R-L+1 >longestStr){
                longestStr= R-L+1;
                m= s.substring(L,R+1);
            }
            //move pointer 
            L--;
            R++;
        }
        
            //For Odd length
        L= i;
         R= i;
        while(L>=0 && R<s.length() && s.charAt(L)==s.charAt(R)){
            //update longest String 
            if(R-L+1 >longestStr){
                longestStr= R-L+1;
                m= s.substring(L,R+1);
            }
            //move pointer 
            L--;
            R++;
        }
    }
        return m;
  }
    
}