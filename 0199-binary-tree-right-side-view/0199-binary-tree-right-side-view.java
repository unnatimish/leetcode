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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        bfs(root,ans);
        return ans;
    }
    private void bfs(TreeNode root, List<Integer> ans){
       if(root==null) return ;
       Queue<TreeNode> q= new LinkedList<>();
       q.offer(root);
       while(!q.isEmpty()){
           List<Integer> temp= new ArrayList<>();
           int n= q.size();
           for(int i=0;i<n;i++){
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
           }
           ans.add(temp.get(temp.size()-1));
       }
    }
}