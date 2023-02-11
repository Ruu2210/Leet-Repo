class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[]={-1,-1};
        
        int start = search(nums,target,true);
        int end = search(nums,target,false);
        
        ans[0]=start;
        ans[1]=end;
        
        return ans;
        
        
    }
    
    //this function return return value of what we are find
   public int search(int[] nums,int target,boolean findfirstindex){
        int ans=-1;
        int start=0;
        int end = nums.length-1;
        while(start<=end){
            int mid=start + (end-start)/2;
            if(target>nums[mid]) start=mid+1;
            else if(target<nums[mid]) end=mid-1;
            else {
                //here we found potential answer
             ans=mid;   
                //now check in right or left side
                if(findfirstindex){
                    end= mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        return ans;
    }
}