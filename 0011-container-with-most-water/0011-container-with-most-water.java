class Solution {
    public int maxArea(int[] height) {
        // Two Pointer Approach 
        int left_pt=0;
        int right_pt=height.length-1;
        int max=0;
      while(left_pt<right_pt){
            int distance= right_pt-left_pt;
            int min_height = Math.min(height[left_pt],height[right_pt]);
            max = Math.max(max,distance*min_height);
          
                if(height[left_pt] < height[right_pt] ) left_pt++;
                    else right_pt--;
        }
        return max;
    }
}