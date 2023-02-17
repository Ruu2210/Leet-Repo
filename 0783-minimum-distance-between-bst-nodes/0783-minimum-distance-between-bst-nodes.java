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
    int ans = Integer.MAX_VALUE;
    TreeNode parent= null;
    public int minDiffInBST(TreeNode root) {
    if(root.left != null) minDiffInBST(root.left);
        
        if(parent!= null) ans=Math.min(ans,root.val-parent.val);
            parent=root;
        if(root.right!= null) minDiffInBST(root.right);
        return ans;
    }
    
}