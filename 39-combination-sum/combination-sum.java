class Solution {
    public void dfs(int[] candidates, int target, int i, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (i >= candidates.length || target < 0) return;

        cur.add(candidates[i]);
        dfs(candidates, target - candidates[i], i, cur, res);
        cur.remove(cur.size() - 1);

        dfs(candidates, target, i + 1, cur, res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
}