class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        boolean found = true;

        while (found) {
            found = false;
            for (int i = 0; i < n; i++) {
                if (nums[i] == original) {
                    original = original * 2;
                    found = true;
                    break;
                }
            }
        }
        return original;
    }
}
