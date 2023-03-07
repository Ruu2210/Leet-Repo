/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
      
        
        if(root == null) return new ArrayList<>();
        
         Queue<TreeNode> q = new LinkedList<TreeNode>(); //step1
          q.add(root);
    
        while(!q.isEmpty()){ //step2  
            
            ArrayList<Integer> level = new ArrayList<>();
            int n = q.size();
            
            for(int i=0;i<n;i++){  //Step3) itr in nodes of each level
                
                TreeNode currNode = q.poll();
                
                level.add(currNode.val);
                
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
            result.add(level);
        }
            return result;
    }
}