class Solution {
    public int compress(char[] chars) {
        //If the group's length is 1, append the character to s.
        
        //1)initialize two pointer i and j and count=1;
        int i=0;
        
        for(int j=1 ,count=1; j<=chars.length; j++,count++)
        {
            //check if we find 2 different characters
            if(j== chars.length || chars[j]!= chars[j-1]){
                //if its true now its time to put character in ith position and after that its count if count>=2
            chars[i] = chars[j-1];
                i++;
                
                if(count>=2){
                    //convert int value of count into string as we need to append string value in array
                    String countStr = String.valueOf(count);
                    for(int k =0; k<countStr.length(); k++){
                        chars[i]=countStr.charAt(k);
                        i++;
                    }
            }
            //now make count=0 for new fresh count
                count =0;
        }
    }
        //i is our length of new array
        return i ;
  }
}