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

    private boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        calculateHeight(root);    
        return balanced;
    }

    private int calculateHeight(TreeNode root){
        if(root == null) return 0;
        int leftHeight = calculateHeight(root.left)+1;
        int rightHeight = calculateHeight(root.right)+1;
        if(Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
            return 0;
        }
        return Math.max(leftHeight, rightHeight);
    }
}

// dfs

// if abs(leftHeight - rightHeight) > 1 return false
// Ending condition: if root == null 