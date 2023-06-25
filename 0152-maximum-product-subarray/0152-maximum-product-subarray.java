class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int mi = ans;
        int ma = ans;
        
        for(int i=1; i<nums.length; i++){
            //here check if current ele arr[i]<0 means swap ma and mi element
            if(nums[i]<0){
                int temp = ma;
                ma = mi;
                mi = temp;
            }
            
            ma = Math.max(nums[i], nums[i]*ma); 
            //either it start from current value or take previous values products as well
            mi = Math.min(nums[i], nums[i]*mi);
            
            ans = Math.max(ans,ma); //ans is max value between ma and ans
        }
        return ans;
    }
    
    
}