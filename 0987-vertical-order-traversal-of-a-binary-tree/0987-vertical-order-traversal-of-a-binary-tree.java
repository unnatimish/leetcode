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
class Pair{
     TreeNode node;
     int col;

    Pair(TreeNode node,int col){
        this.node=node;
        this.col=col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer,List<Integer>>> map = new TreeMap<>();
       bfs(root, map,0);
        System.out.println(map);
        for(int col:map.keySet()){
            List<Integer> li = new ArrayList<>();
            Map<Integer,List<Integer>> rowMap=map.get(col);
            for(int row: rowMap.keySet()){
                List<Integer> temp= rowMap.get(row);
                Collections.sort(temp);
                li.addAll(temp);
            }
            ans.add(li);
        }

        return ans;

    }

   

    private void bfs(TreeNode root, 
    TreeMap<Integer, TreeMap<Integer,List<Integer>>> map,int level) {
        if(root==null) return ;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Pair p = q.poll();
                TreeNode node =p.node;
                int col=p.col;
                if (map.containsKey(col)) {
                    TreeMap<Integer,List<Integer>> rowMap= map.get(col);
                    if(rowMap.containsKey(level)){
                        rowMap.get(level).add(node.val);
                    }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(node.val);
                    rowMap.put(level,list);
                    map.put(col, rowMap); 
                    }
                } else {
                    TreeMap<Integer,List<Integer>> rowMap = new TreeMap<>();
                    List<Integer> list = new ArrayList<>();
                    list.add(node.val);
                    rowMap.put(level,list);
                    map.put(col, rowMap);
                }
                if (node.left != null) {
                    q.offer(new Pair(node.left,col-1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right,col+1));

                }
            }
            level++;

        }

    }
}