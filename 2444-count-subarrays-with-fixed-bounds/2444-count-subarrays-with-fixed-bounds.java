class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
      
   long sum = 0;
   int start = 0;
   int minStart = 0;
   int maxStart = 0;
   boolean  minf = false, maxf = false;

   for(int i = 0; i < nums.length; i++){
       int num = nums[i];
       if(num < minK || num > maxK){
         //reset all
           minf = false;
           maxf = false;
           start = i+1;
       }

       if(num == minK){
           minf = true;
           minStart = i;
       }

       if(num == maxK){
           maxf = true;
           maxStart = i;
       }

       if(minf && maxf){
           sum += (Math.min(minStart, maxStart) - start+1);
       }
   } 

   return sum;
    }
  }
