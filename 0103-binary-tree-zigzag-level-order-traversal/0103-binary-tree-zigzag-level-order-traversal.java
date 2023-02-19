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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         if(root== null)  return new ArrayList();  
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode>q = new LinkedList();
        q.add(root);
        boolean reversalLevel =  false; //initali it is false in next level it will true 
        
        while(!q.isEmpty()){
            int Qsize = q.size();
            List<Integer>level = new ArrayList();
            while(Qsize-->0){
                root=q.poll();
                level.add(root.val);
                if(root.left!=null) q.add(root.left);
                if(root.right!=null) q.add(root.right);
            }
            if(reversalLevel) Collections.reverse(level);
            result.add(level);
            reversalLevel=!reversalLevel;
        }
        return result;
    }
}