class Solution {
    public int countElements(int[] nums) {
        int minEle = nums[0];
        int maxEle = nums[0];
        int count=0;
        for(int i:nums){
            minEle= Math.min(minEle,i);
            maxEle= Math.max(maxEle,i);
        }
        for(int i: nums){
            if(i>minEle && i<maxEle) count++;
        }
        //Solve using max and min number between this two is our ans
        //return count of such number
        return count;
    }
}