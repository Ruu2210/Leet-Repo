class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans =0;
        long count =0;
        
        for(int i: nums){
            if(i == 0) {
            count++;
            }
            else count=0;
            ans+=count;
        }
        return ans;
    }
}