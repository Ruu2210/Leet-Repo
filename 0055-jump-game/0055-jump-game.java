class Solution {
    public boolean canJump(int[] nums) {
        int ans =minJumps(nums);
        if(nums.length == 1) return true;
       else if(ans == -1) return false;
        else return true;
        
    }
    static int minJumps(int[] arr){
        // your code here
        if(arr.length<=1) return -1;
        if(arr[0] == 0) return -1;
        
        int maxReach = arr[0];
        int steps = arr[0];
        int jump=1;
        
       // int i=1;
        for(int i=1; i<arr.length; i++){
            if(i == (arr.length-1)) return jump;
            
             steps--;
            
            maxReach = Math.max(maxReach , i+arr[i]);
           
            if(steps == 0){
                jump++;
                if(i>= maxReach) return -1;
                steps = maxReach-i;
            }
        }
        return -1;
    }
}