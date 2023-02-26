//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String word1, String word2) {
        // Code here
         //We can solve this problem with 2 approaches 
        //a) Recursive 
        //b) Matrix = https://www.youtube.com/watch?v=eMnyEDYGobA
        int a= word1.length();
        int b= word2.length();
        
        //Now create DP array
        int DP[][]= new int [a+1][b+1]; //at DP[0][0] we have empty String
        //insert 1st row and column 
        for(int i=0;i<=a;i++) DP[i][0]=i; //insert 1st row where j =0
        for(int j=0;j<=b;j++) DP[0][j]=j; //insert 1st column where i=0 
        
        //now insert remaning after comparing the options
        //take minimum(from 3 options)+1;
        for(int i =1;i<=a;i++){
            for(int j=1;j<=b;j++){
                //write diagonal elements as it if characters are matched  
                if(word1.charAt(i-1) == word2.charAt(j-1)) DP[i][j]=DP[i-1][j-1];  
                else{
                DP[i][j] = 1+ Math.min(DP[i-1][j-1],Math.min(DP[i][j-1],DP[i-1][j]));
              }
            }
        }
        
        return DP[a][b];
        
        
    }
  }
