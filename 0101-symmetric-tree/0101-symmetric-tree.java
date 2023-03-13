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
    public boolean isSymmetric(TreeNode root) {   
        if(root == null) return true;
        return check(root.left,root.right);
    }
    
    public boolean check(TreeNode leftSubtree, TreeNode rightSubtree){
        if(leftSubtree == null && rightSubtree == null) return true;
        else if(leftSubtree == null || rightSubtree == null) return false;
        else{
            if(leftSubtree.val == rightSubtree.val && check(leftSubtree.left,rightSubtree.right)&&check(leftSubtree.right,rightSubtree.left)) return true;
            else return false;
        }
        
    }
  }
