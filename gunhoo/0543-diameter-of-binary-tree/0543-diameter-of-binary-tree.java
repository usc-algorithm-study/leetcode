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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root.right == null && root.left == null) return 0;
        int dis = 0;
        if(root.right == null){
            dis = distanceToLeafNode(root.left);
            return Math.max(max, dis);
        }
        if(root.left == null){
            dis = distanceToLeafNode(root.right);
            return Math.max(max, dis);
        }
        dis = distanceToLeafNode(root.right) + distanceToLeafNode(root.left);
        return Math.max(max, dis);
    }

    private int distanceToLeafNode(TreeNode node){
        if(node.left == null && node.right == null) return 1;
        if(node.right != null) {
            int right = distanceToLeafNode(node.right);
            if(node.left != null){
                int left = distanceToLeafNode(node.left);
                max = Math.max(max, right + left);
                return Math.max(right, left) + 1;
            }
            return right + 1;
        }
        if(node.left != null) {
            int left = distanceToLeafNode(node.left);
            if(node.right != null){
                int right = distanceToLeafNode(node.right);
                max = Math.max(max, right + left);
                return Math.max(right, left) + 1;
            }
            return left + 1;
        }
        return 0;
    }
}