class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        //map of value and their possible options
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i],l -> new ArrayList()).add(i);
            //computeIfAbsent(Key, Function)  
            //key : key for which we want to compute value using mapping
            //remappingFunction : function to do the operation on value.
        }
        
        Queue<Integer> q = new LinkedList();
        Set<Integer> visited = new HashSet();
        
        q.add(0);
        visited.add(0);
        int steps =0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(size-->0){
                int i = q.poll();
                if(i == n-1) return steps;
                
                List<Integer> adjList = map.get(arr[i]);
                adjList.add(i-1);
                adjList.add(i+1);
                
                for(int j: adjList){
                    if(j>=0 && j<n && !visited.contains(j)){
                        q.add(j); 
                        visited.add(j);
                    }
                }
                adjList.clear(); //stop repeated calculation by removing
            }   
               steps++;
        }
          return -1;
    }
    
}