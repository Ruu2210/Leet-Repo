class Solution {
    public int search(int[] nums, int target) {
    int pivot = findPivot(nums);
    
    //if we did not find pivot means the array is not rotated
    
    if (pivot == -1 ) {
        //do simple binary search to find out target 
        return binarySearch(nums,target,0, nums.length-1);
        
    }
    //if pivot is found we found 2 ascending sorted array
    //cases to find target using pivot

    if(nums[pivot] == target){
        return pivot;
    }
    if(target >= nums[0]) {
        return binarySearch(nums,target,0 , pivot-1);
     }
  return binarySearch(nums,target , pivot+1 , nums.length - 1);
    

}
    int binarySearch(int [] nums, int target, int start , int end ){
        while(start<= end) {
            int mid = start+(end-start)/2;
            if(target< nums[mid]) end= mid-1;
            else if (target > nums[mid]) start=mid+1;
            else return mid;
            
        }
        return -1;
    }
    
    
    int findPivot(int nums[]){
       if(nums.length==1) return -1;
        int start=0;
        int end=nums.length-1;
        
        while(start<=end){
          int mid= start+(end-start)-1;
            //4 cases
            if (mid<end && nums[mid] > nums[mid+1] ){
                return mid;
            }
            if (mid>start && nums[mid] <nums[mid-1]){
                return mid-1;
            }
            if( nums[mid] <= nums[start]){
                end=mid-1;
            }
            else start=mid+1 ;
            
        }
        return -1;
    }
    
}
