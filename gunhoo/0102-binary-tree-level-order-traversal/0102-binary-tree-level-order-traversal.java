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
    private List<List<Integer>> levelOrderList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return levelOrderList;
        bfs(root, 0);
        return levelOrderList;
    }

    private void bfs(TreeNode root, int level){
        if(levelOrderList.size() <= level){
            levelOrderList.add(new ArrayList<>());
        }
            levelOrderList.get(level).add(root.val);
        
        if(root.left != null) bfs(root.left, level+1);
        if(root.right != null) bfs(root.right, level+1);
    }
}