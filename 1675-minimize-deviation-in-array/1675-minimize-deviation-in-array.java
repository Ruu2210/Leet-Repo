class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int minValue=Integer.MAX_VALUE;
        for(int y:nums){
            if((y&1)==1)
                y<<=1;
            pq.add(y);
            minValue=Math.min(minValue,y);
        }
        int minDeviation=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int currunt=pq.poll();
            minDeviation=Math.min(minDeviation,currunt-minValue);
            if((currunt&1)==1)
                break;
            currunt>>=1;
            minValue=Math.min(minValue,currunt);
            pq.add(currunt);
        }
        return minDeviation;
    }
}