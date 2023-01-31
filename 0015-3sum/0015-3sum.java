class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    //create set for ignore duplicates
        Set<List<Integer>> output_arr = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum = nums[j]+nums[k];
                if(sum == -nums[i]) {
                    output_arr.add(Arrays.asList(nums[i],nums[j++],nums[k--])); //if we find pair increment i,j and decrement k
                }
                else if(sum >-nums[i]) k--;
                else if(sum < -nums[i]) j++;
            }
            
        }
        return new ArrayList<>(output_arr);
        
    }
}