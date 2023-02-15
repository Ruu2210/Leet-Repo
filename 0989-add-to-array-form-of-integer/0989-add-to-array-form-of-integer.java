class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int N = num.length;
        int i=N-1;
        //we need to find list so create answer list
        List<Integer>Answer= new ArrayList<>();
        while(i>=0 || k>0){
            //k is given 
            if(i>=0){
                Answer.add((num[i]+k)%10);
                k= (num[i]+k)/10; 
            }
            //if our i<0 and k>0 
            else{
                Answer.add(k%10);
                k=k/10;
                //run till our k becomes zero
            }
            i--;
            //we store our answer in reverse order so while returning we have to reverse our list
            //for reversing list we use Collections.reverse(Answer)
            //reverse() method of Collections class
        }
        Collections.reverse(Answer);
        return Answer;
    }
}