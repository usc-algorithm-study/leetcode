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
    public int countNodes(TreeNode root) {
        if(root == null ) return 0;
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int count){
        int sum = count;
        if(root.left != null){
            sum += dfs(root.left, count);
        }
        if(root.right != null){
            sum += dfs(root.right, count);
        }
        if(root.right == null && root.left == null){
            return 1;
        }
        return sum+1;
    }

}