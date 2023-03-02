class Solution {
    public int compress(char[] chars) {
        //here we use 2 pointer 
        int i=0;
        //at start we consider count=1
        for(int j=1 ,count =1; j<= chars.length ; j++ ,count++){
            if(j == chars.length || chars[j]!= chars[j-1]){
                chars[i]= chars[j-1];
                i++;
            
            if(count>=2){
                 String countStr = String.valueOf(count);
                for (int k = 0; k < countStr.length(); k++) {
                    chars[i] = countStr.charAt(k);
                    i++;
                }
            
            
            }count =0;
        }
        }
        return i;
    }
}