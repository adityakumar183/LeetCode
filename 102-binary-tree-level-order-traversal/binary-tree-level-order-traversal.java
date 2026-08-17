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

    public void nThLevel(TreeNode root, int level,int lvl,List<Integer> arr){
        if (root == null) return;
        if(level>lvl) return;
        if(level==lvl) arr.add(root.val);
        nThLevel(root.left, level+1,lvl,arr);
        nThLevel(root.right, level+1,lvl,arr);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // List<List<Integer>> result = new ArrayList<>();
        // if (root == null) return result;

        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);

        // while (q.size()>0) {
        //     int size = q.size();
        //     List<Integer> level = new ArrayList<>();

        //     for (int i = 0; i < size; i++) {
        //         TreeNode node = q.poll();
        //         level.add(node.val);

        //         if (node.left != null) q.add(node.left);
        //         if (node.right != null) q.add(node.right);
        //     }
        //     result.add(level);
        // }
        // return result;

        List<List<Integer>> ans = new ArrayList<>();
        int lvl = levels(root);
        for(int i = 0;i<=lvl-1;i++){
            List<Integer> arr = new ArrayList<>();
            nThLevel(root,0,i,arr);
            ans.add(arr);
        }
        return ans;
    }
}