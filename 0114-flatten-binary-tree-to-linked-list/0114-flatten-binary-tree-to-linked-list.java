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
    public void flatten(TreeNode root) {
        TreeNode curr= root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode leftNode = curr.left;
                while(leftNode.right!=null){
                    leftNode=leftNode.right;
                }
                 leftNode.right = curr.right;

                curr.right = curr.left;

                curr.left = null;
                ////
                // leftNode.right=curr;
                // leftNode.left=null;
                // TreeNode temp=curr.left;
                // curr.left=null;
                // curr=temp;
            }else{
                curr=curr.right;
            }
        }
       
       
        
    }
   
}