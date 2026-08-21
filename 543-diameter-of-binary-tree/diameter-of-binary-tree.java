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
    public int levels(TreeNode root, int[] maxdia) {
        if (root == null) return 0;
        int leftlevels = levels(root.left, maxdia);
        int rightlevels = levels(root.right, maxdia);
        int dia = leftlevels + rightlevels;
        maxdia[0] = Math.max(dia, maxdia[0]);
        return 1+ Math.max(leftlevels,rightlevels);

    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxdia = {0};
        levels(root,maxdia);
        return maxdia[0];
    }
}