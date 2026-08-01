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
class Pair {
    TreeNode node;
    Long index;

    Pair(Long index, TreeNode node) {
        this.index = index;
        this.node = node;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return bfs(root);
    }

    private int bfs(TreeNode root) {
        int max = 0;
        if (root == null)
            return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0L, root));
        while (!q.isEmpty()) {
            TreeMap<Long, Integer> map = new TreeMap<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Pair p = q.poll();
                TreeNode node = p.node;
                map.put(p.index, p.node.val);

                if (node.left != null) {
                    q.offer(new Pair(2 * p.index, node.left));
                }
                if (node.right != null) {
                    q.offer(new Pair(2 * p.index + 1, node.right));
                }
            }
            System.out.println(map);
            // if (map.size() == 1) {
            //     max = Math.max(max,map.firstKey());
            // } else {
                max = (int)Math.max(max, map.lastKey() - map.firstKey() + 1);
           // }

        }
        return max;
    }
}