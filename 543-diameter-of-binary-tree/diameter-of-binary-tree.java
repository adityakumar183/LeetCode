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
    public int levels(TreeNode root) {
        if (root == null) return 0;
        int level = 1 + Math.max(levels(root.left), levels(root.right));
        return level;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int rootDia = levels(root.left) + levels(root.right);
        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);
        return Math.max(rootDia, Math.max(leftDia, rightDia));
    }
}