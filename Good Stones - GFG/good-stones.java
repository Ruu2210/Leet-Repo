//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.goodStones(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {static int dp[];
    public static int goodStones(int n, int[] arr) {
        // code here
        dp= new int[n];
        for(int i=0;i<n;i++){
            //if dp[i] ==0 means it is unvisited
            if(dp[i]==0){
                solve(arr,n,i);
            }
        }
        int ans=0;
        for(int x:dp) if(x==2) ans++; 
        return ans;
       
    }
    //here we pass i to check if array is out of bound or not
    // stone is good if it is out off bound
    static int solve(int arr[],int n,int i){
       //good stone 
       if(i<0 || i>=n) return 2;
       
       if(dp[i] ==1 || dp[i]==2) return dp[i];
       
       dp[i]=1;
       return dp[i]= solve(arr,n,i+arr[i]);
        
    }
 
}

        
