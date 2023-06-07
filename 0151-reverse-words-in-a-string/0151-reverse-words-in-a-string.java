class Solution {
    public String reverseWords(String s) {
        
        //convert string s to string array
        String[] words = s.split(" +"); //space+  means any number of spaces 
        //use string builder as it is mutable 
        StringBuilder sb = new StringBuilder();
        
        //reverse loop to reverse the array 
        for(int i=words.length-1;i>=0;i--){
           sb.append(words[i]);
            sb.append(" ");
        }
        //convert StringBuilder to string and also trim() removes all extra spaces 
        return sb.toString().trim();
        
        //trim()= removes all spaces from text except for single space between words
    }
}