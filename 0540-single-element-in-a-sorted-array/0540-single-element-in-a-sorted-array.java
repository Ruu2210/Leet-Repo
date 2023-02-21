class Solution {
    static  int uniqueEle=0;
    public int singleNonDuplicate(int[] nums) {
        int start1 =0;
        int end1= nums.length-1;
        solve(start1,end1,nums);
        return uniqueEle;
    }
    
    static void solve(int start,int end, int []nums){
        int mid = start+(end-start)/2;
        //1st base condition if mid is unique number
        if(start==end) {
            uniqueEle=nums[start];
                return;
        }
        int start1=start, start2=start, end1=end, end2=end;
        
        if(nums[mid]!=nums[mid-1] && nums[mid]!= nums[mid+1]) {
            uniqueEle=nums[mid];
            return;
        }
        if(nums[mid]==nums[mid-1]){
            start1=start;
            end1=mid-2;
            start2=mid+1;
            end2=end;
        }
        if(nums[mid]==nums[mid+1]){
            start2 = mid+2;
            end2= nums.length-1;
            start1=start;
            end1=mid-1;
        }
        //Now check wheahter left or right sequence is even or odd
        if((end1-start1+1)%2!=0) {
            solve(start1,end1,nums);
        }
        if((end2-start2+1)%2!=0){
           solve(start2,end2,nums);
        } 
        
       
    }
    
    
}