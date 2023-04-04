class Solution {
    public int partitionString(String s) {
        int ans=1; //inital string is also our substring
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            
            if(map.containsKey(s.charAt(i))){
                map.clear();
                ans++;
            }
            
           map.put(s.charAt(i),1);
        }
        return ans;
    }
}