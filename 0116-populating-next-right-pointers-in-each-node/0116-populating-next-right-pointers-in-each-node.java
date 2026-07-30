/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        bfs(root);
        return root;
    }
    private void bfs(Node root){
       if(root==null) return ;
       Queue<Node> q= new LinkedList<>();
       q.offer(root);
       while(!q.isEmpty()){
           List<Node> temp= new ArrayList<>();
           int n= q.size();
           for(int i=0;i<n;i++){
                Node node = q.poll();
                temp.add(node);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
           }
           for(int i=0 ;i<temp.size()-1;i++){
                if(i==temp.size()-1){
                    temp.get(i).next=null;
                }else{
                    temp.get(i).next=temp.get(i+1);
                }
           }

       }
    }
    
}