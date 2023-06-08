//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution {
    public static String kthPermutation(int n,int k) {
        // code here
        
        int factorial = 1;
        String ans = "";
        
        //create list where we store our n numbers and if we find out which is our number put this in ans string
        List<Integer> numbers = new ArrayList<>();
        
        for(int i =1; i<n ; i++){
            //this gives the number of permutation in 1 block
            //like is k=4 means 3 and n=4 we have 1*2*3=6 permutation in each block 
            //at end factorial will change as n is change
            factorial = factorial*i;
            numbers.add(i);
        }
        
        //now add last value in list 
        numbers.add(n);
        // 0 base indexing so value of k becomes k-1
        k=k-1;
        
        while(true){
            int value = numbers.get(k/factorial);
            //now put this value in answer as we need string as output
            ans+=value;
            //also remove that value from list  remove(int index) 
            numbers.remove(k/factorial);
            
            if(numbers.size()==0) break; //as we get our kth permutation sequence
            
            //now for next k value 
            k= k% factorial;
            //also change factorial as size of numbers are reduce  is change
            factorial = factorial/ numbers.size();
        }
        return ans;
    }
}
        


//{ Driver Code Starts.

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
            
            int[] a = IntArray.input(br, 2);
            
            Solution obj = new Solution();
            String res = obj.kthPermutation(a[0],a[1]);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends