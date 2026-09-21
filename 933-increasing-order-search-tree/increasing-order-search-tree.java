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
    public TreeNode inorder(TreeNode node, TreeNode curr) {
        if (node == null) return curr;

        curr = inorder(node.left, curr);

        curr.right = node;
        node.left = null;
        curr = node;

        return inorder(node.right, curr);
    }
    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        TreeNode curr = dummy;
        inorder(root, curr);
        return dummy.right;
    }
}
