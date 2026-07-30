class Solution {
    public int minimumPushes(String s) {
        int n = s.length();
        int cost = 0;
        int pushes = 1;
        while (n > 0) {
            int group = Math.min(8, n);
            cost += group * pushes;
            n -= group;
            pushes++;
        }
        return cost;
    }
}