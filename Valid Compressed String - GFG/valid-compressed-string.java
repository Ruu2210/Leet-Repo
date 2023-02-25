//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
        int i=0; //for S string
        int j=0; //for T string
        
        while(i<T.length()&& j<S.length()){
            if(T.charAt(i)>='0' && T.charAt(i)<='9'){ 
                
                int count=0;
                
                while(i<T.length() && (T.charAt(i)>='0' && T.charAt(i)<='9')){
                    count=count*10+(T.charAt(i)-'0');
                    i++;
                } 
                j=j+count;
            }
            else if(T.charAt(i)!=S.charAt(j)){
            return 0;
            }
            else{
            i++;
            j++;
            }
        }
        if(i==T.length() && j==S.length()){
            return 1;
        }
        return 0;
    }
}