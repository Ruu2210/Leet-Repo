class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        //1,2,3,4,6,8,2,3,5 
        //here 8 is the peak index 
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid= start+(end-start)/2;
        
            if(arr[mid]<arr[mid+1]){
                //you are in acsending part of the array
                //bcoz we know mid+1>mid ,we ignore mid and make start=mid+1 
             start=mid+1;
            }
            else{ 
                //here mid>mid+1,so we are in descending part of array
                //maybe mid is the answer,but look at the left
                //thats why here end!=mid-1;
                end=mid;
            }
        }
        //in the end start==end,both pointing to the largest element of array bcoz of above 2 checks
        //at every point start and end have best possible answer
        //but if only one item is left at that time only we can say this is the answer
        return start; //or return end; bcoz start==end
    }
}