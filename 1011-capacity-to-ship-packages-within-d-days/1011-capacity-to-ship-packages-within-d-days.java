class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min=0;
        int max=0;
        for(int w: weights){
            min=Math.max(w,min);
            max=max+w;
        }
        int retValue =0;
        while(min<= max){
            int mid= (min+max)/2;
            int requiredDays = returnMinDays(weights,mid);
            
            if(requiredDays>days){
                min= mid+1;
            }
            else{
                retValue = mid;
                max= mid-1;
            }
        }
        return retValue;
    }
    
    private int returnMinDays(int[]weights,int capacity) {
        int daysRequired =1;
         int current =0;
        for(int w:weights){
           current+=w;
            if(current> capacity){
                daysRequired++;
                current=w;
            }
        }
        return daysRequired;
    }
    
}