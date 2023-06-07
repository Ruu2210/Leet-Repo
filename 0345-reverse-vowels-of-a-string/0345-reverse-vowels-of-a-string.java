class Solution {
    public String reverseVowels(String s) {
        //solve using stack
        Stack<Character>st = new Stack<>();
        
        //we push only vowels in stack
        String vowels = "aeiouAEIOU";
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //check if c is vowel or not 
        if(vowels.contains(String.valueOf(c))) st.push(c);   
        }
        
        String result ="";
        
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
           if(vowels.contains(String.valueOf(c))){
               //pop the stack and append pop value to result
               result += st.pop();
           }
            else result+=c;
        }
        return result;
    }
}