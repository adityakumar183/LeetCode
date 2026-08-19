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
    public void dfs(TreeNode root, int level,List<Integer> ans){
        if(root==null) return;
        ans.set(level,root.val);
        dfs(root.left,level+1,ans);
        dfs(root.right,level+1,ans);
    }

    public int levels(TreeNode root){
        if (root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = levels(root);
        for(int i=0; i<n; i++){
            ans.add(0);
        }
        dfs(root,0,ans);
        return ans;
    }
}