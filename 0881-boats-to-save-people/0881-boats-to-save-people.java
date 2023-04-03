
   class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
       // Arrays.sort(people);
        //count algorithm for sorting 
        
        int [] count= new int[limit+1];
        for(int p:people){
            count[p]++;
        }
        
        int index=0;
        
        for(int val=1;val<=limit;val++){
            while(count[val]-->0){
                people[index++]=val;
            }
        }
        
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            int sum = people[left] + people[right];
            if(sum <= limit){
                left++;
                right--;
            }
            else{
           
                right--;
            }
            boatCount++;
        }
        return boatCount;
    }
}
