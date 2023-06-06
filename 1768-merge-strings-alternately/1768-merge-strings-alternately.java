class Solution {
    public String mergeAlternately(String word1, String word2) {
      int w1length = word1.length();
      int w2length = word2.length();
    
        //create StringBuilder as it is mutable 
        StringBuilder output = new StringBuilder();
        int index =0;
        
        while(w1length>index && w2length>index){
            output.append(word1.charAt(index));
            output.append(word2.charAt(index));
            index++;
        }
        
        //If a string is longer than the other
        //append the additional letters onto the end of the merged string.
        output.append(word1.substring(index,w1length));
        output.append(word2.substring(index,w2length));
        
        return output.toString();
    }
}