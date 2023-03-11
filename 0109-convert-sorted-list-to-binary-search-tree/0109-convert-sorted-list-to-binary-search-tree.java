/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    //Height balanced bst means the difference between the heights of the left
    //and the right subtree for any node is not more than one.
    
    // Here the slow starts from head and fast from head.next.next so that our slow pointer will stop at previous element of mid element of list.
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        
        if(head.next==null)
            return new TreeNode(head.val);
        
        ListNode slow=head;
        ListNode fast=head.next.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        TreeNode res=new TreeNode(slow.next.val); // slow's next is the root
        
        //then store the pointer of right subtree (here it's righthalf node) by moving two step ahead because we know our right subtree will start after the root or you can say mid element of the list.
        ListNode righthalf=slow.next.next;
        
        // After storing we make slow's next to null so there will be no link with further elements of list.
        slow.next=null;
        
        //we will start making the tree from left and right by assigning the root's left as the head and root's right as righthalf node. Then this process goes on recursively again and again until we reach the base condition.
        res.left=sortedListToBST(head);
        res.right=sortedListToBST(righthalf);
        return res;
    }
}