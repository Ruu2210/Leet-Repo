class Solution {
    public String gcdOfStrings(String str1, String str2) {
       //check if string is concatenated or not
        if(!(str1+str2).equals(str2+str1)) return "";
        
        //find gcd of both string
        int gcd = gcd(str1.length() , str2.length());
        return str1.substring(0,gcd);
    }
        private static int gcd(int a, int b){
            return b==0 ? a : gcd(b,a%b);
        }
}