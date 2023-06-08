class Solution {
    public int[] productExceptSelf(int[] nums) {
        //now solve using only one result array no extra space
        int n = nums.length;
        int [] result = new int[n];
        
        int productOfAllBeforeCurrent = 1;
        int ProductOfAllAfterCurrent  = 1;
        
        //put productOfAllBeforeCurrent in result
        for(int i=0; i<n; i++){
            result[i]=productOfAllBeforeCurrent;
            productOfAllBeforeCurrent = productOfAllBeforeCurrent*nums[i]; 
        }
        
        for(int i=n-1; i>=0; i--){
            result[i] =  result[i] * ProductOfAllAfterCurrent;
            ProductOfAllAfterCurrent = ProductOfAllAfterCurrent*nums[i];
        }
        return result;
        
    }
}