1) Brute Force Approach
​
class Solution {
public int maxArea(int[] height) {
// brute force approach  Time Complexity: O(n2)
int maxarea=0;
for(int left=0;left<height.length;left++){
for(int right=left+1;right<height.length;right++){
int min_h = Math.min(height[left],height[right]);
int distance=right-left;
maxarea = Math.max(maxarea,min_h*distance);
}
}
return maxarea;
}
}