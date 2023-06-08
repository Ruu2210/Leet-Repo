class Solution {
    public String getPermutation(int n, int k) {
        
        int factorial = 1;
        String ans = "";
        
        //create list where we store our n numbers and if we find out which is our number put this in ans string
        List<Integer> numbers = new ArrayList<>();
        
        for(int i =1; i<n ; i++){
            //this gives the number of permutation in 1 block
            //like is k=4 means 3 and n=4 we have 1*2*3=6 permutation in each block 
            //at end factorial will change as n is change
            factorial = factorial*i;
            numbers.add(i);
        }
        
        //now add last value in list 
        numbers.add(n);
        // 0 base indexing so value of k becomes k-1
        k=k-1;
        
        while(true){
            int value = numbers.get(k/factorial);
            //now put this value in answer as we need string as output
            ans+=value;
            //also remove that value from list  remove(int index) 
            numbers.remove(k/factorial);
            
            if(numbers.size()==0) break; //as we get our kth permutation sequence
            
            //now for next k value 
            k= k% factorial;
            //also change factorial as size of numbers are reduce  is change
            factorial = factorial/ numbers.size();
        }
        return ans;
    }
}