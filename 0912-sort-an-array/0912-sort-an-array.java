class Solution {
    public int[] sortArray(int[] nums) {
        //sort an array using Counting Sort 
        //Counting sort is a sorting technique based on keys between a specific range. It works by counting the number of objects having distinct key values (a kind of hashing). 
        HashMap<Integer , Integer > map = new HashMap<>();
        
        int maxEle = Integer.MIN_VALUE;
        int minEle = Integer. MAX_VALUE;
        
        // Now map the freq of values 
    for(int i = 0 ; i<nums.length ; i++){
        
        if(map.containsKey(nums[i])){
            map.put(nums[i],map.get(nums[i])+1);
        }
        else map.put(nums[i],1);
        //also update max and min ele 
        //bcoz int counting sort we required range
        maxEle = Math.max(maxEle , nums[i]);
        minEle = Math.min(minEle , nums[i]);
    }
        
        int i =0;
        for(int j= minEle;j<= maxEle ; j++){
            if(map.containsKey(j)) {
                while(map.get(j) >= 1){
                    nums[i]=j; //put value in nums 
                    map.put(j,map.get(j)-1); //update in value in map
                    i++;
                }
            }
        }
        return nums;
    
        
    }
}