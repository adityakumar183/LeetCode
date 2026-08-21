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
    // Method 01:-
    // public int height(TreeNode node) {
    //     if (node == null) return 0;

    //     int left = height(node.left);
    //     if (left == -1) return -1;

    //     int right = height(node.right);
    //     if (right == -1) return -1;

    //     if (Math.abs(left - right) > 1) return -1;

    //     return Math.max(left, right) + 1;
    // }
    // public boolean isBalanced(TreeNode root) {
    //     return height(root) != -1;
    // }


    // Method 02:-
    public int levels(TreeNode root, boolean[] ans){
        if(root==null) return 0;
        int leftlevel = levels(root.left, ans);
        int rightlevel = levels(root.right, ans);
        int diff = Math.abs(leftlevel-rightlevel);
        if(diff>1) ans[0] = false;
        return 1 + Math.max(leftlevel,rightlevel);
    }

    public boolean isBalanced(TreeNode root){
        boolean[] ans = {true};
        levels(root,ans);  // TC = O(n)
        return ans[0];
    }
}

// both method are same only difference is code written method.