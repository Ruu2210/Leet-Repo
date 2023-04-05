// Initialize total_sum and result to 0.
// Loop through the nums array from index 0 to len(nums)-1.
// For each index, add the value at that index to the total_sum.
// Calculate the maximum of the current result and the division of total_sum and index+1 using integer division //.
// Update the result with the maximum value.
// Repeat steps 3-5 for all indices.
// Return the result as the minimum maximum of the array.
    


    public class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0;
        long result = 0;
        for (int index = 0; index < nums.length; ++index) {
            sum += nums[index];
            result = Math.max(result, (sum + index) / (index + 1));
        }
        return (int) result;
    }
}
