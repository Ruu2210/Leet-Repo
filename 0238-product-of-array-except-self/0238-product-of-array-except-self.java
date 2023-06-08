class Solution {
    public int[] productExceptSelf(int[] nums) {
        //define array 
        int n= nums.length;
        int [] prefixProductFromStart = new int[n];
        int [] prefixProductFromEnd   = new int[n];
        int [] result = new int[n]; 
        
        //find prefix product
        prefixProductFromStart[0]=nums[0];
        for(int i=1; i<n; i++){
            prefixProductFromStart[i]= prefixProductFromStart[i-1]* nums[i];
        }
        
        prefixProductFromEnd[n-1]= nums[n-1];
        for(int i=n-2; i>=0; i--){
            prefixProductFromEnd[i]=prefixProductFromEnd[i+1]*nums[i];
        }
        
        result[0] = prefixProductFromEnd[1];
        result[n-1] = prefixProductFromStart[n-2];
        
        for(int i=1; i<n-1; i++){
            result[i]= prefixProductFromStart[i-1]* prefixProductFromEnd[i+1];
        }
        
        return result;
        
    }
}