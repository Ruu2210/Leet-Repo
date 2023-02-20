class Solution {
    public int searchInsert(int[] nums, int target) {
        //Binary Search question
        int start=0;
        int end= nums.length-1;
        //int mid= start+(end-start)/2;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target){
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        //here start==end so we can return any of both
        return start;
        
}
}