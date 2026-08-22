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
    public TreeNode helper(int[] inorder, int[] postorder, int inlo, int inhi, int postlo, int posthi) {
        if(postlo>posthi || inlo>inhi) return null;
        TreeNode root = new TreeNode(postorder[posthi]);

        int r = 0;
        while(inorder[r] != postorder[posthi]) r++;
        int leftsize = r - inlo;

        root.left = helper(inorder, postorder, inlo, r-1, postlo, postlo+leftsize-1);
        root.right = helper(inorder, postorder, r+1, inhi, postlo+leftsize, posthi-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return helper(inorder, postorder, 0, n-1, 0, n-1);
    }
}