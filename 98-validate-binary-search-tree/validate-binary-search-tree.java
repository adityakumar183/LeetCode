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
    public long Max(TreeNode root) {
        if (root == null) return Long.MIN_VALUE;
        long max = root.val;
        long leftmax = Max(root.left);
        long rightmax = Max(root.right);

        return Math.max(max,Math.max(leftmax,rightmax));
    }

    public long Min(TreeNode root) {
        if (root == null) return Long.MAX_VALUE;
        long min = root.val;
        long leftmin = Min(root.left);
        long rightmin = Min(root.right);

        return Math.min(min,Math.min(leftmin,rightmin));
    } 
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.val<=Max(root.left)) return false;
        if(root.val>=Min(root.right)) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
}