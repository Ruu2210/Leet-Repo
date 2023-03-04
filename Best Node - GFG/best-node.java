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
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.bestNode(N, A, P);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long bestNode(int n, int[] A, int[] p) {
        // code here
        
        //BFS
        
        //1) Set of non leaf node
        HashSet<Integer> non_leaf = new HashSet<>();
        for(int i=0; i<n ;i++){
            non_leaf.add(p[i]);
        }
        
        //list of leaf node
        ArrayList<Integer>leaf_node = new ArrayList<>();
        for(int i = 1 ;i<= p.length;i++){
            if(!non_leaf.contains(i)) leaf_node.add(i);
        }
        //we start from leaf node
        
        int maxSum= Integer.MIN_VALUE;
        //traverse from leaf to root and store max at each and every time visited new node
        
        for(int leaf : leaf_node){
            int curr_node = leaf;
            int sum =0;
            
            while(curr_node != -1){ //till current node not pointing root bcoz root is -1
            sum = -sum; //make sum - for next operation according to given condition
            sum += (A[curr_node-1]);
            
            maxSum = Math.max(maxSum ,sum);
            //update curr_node
            curr_node = p[curr_node-1];
            }
        }
        
        return maxSum;
    }
    
    
}
        
