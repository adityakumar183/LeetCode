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
    public void traverse(TreeNode node, HashMap<Integer,Integer> freq) {
        if (node == null) return;
        freq.put(node.val, freq.containsKey(node.val) ? freq.get(node.val) + 1 : 1);
        traverse(node.left, freq);
        traverse(node.right, freq);
    }

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        traverse(root, freq);

        int max = 0;
        for (int f : freq.values()) max = Math.max(max, f);

        List<Integer> modes = new ArrayList<>();
        for(Integer key : freq.keySet()){
            if(freq.get(key) == max){
                modes.add(key);
            }
        }

        int[] result = new int[modes.size()];
        for(int i = 0; i<modes.size(); i++){
            result[i] = modes.get(i);
        }

        return result;
    }
}
