class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] target = new int[n];
        int size = 0;

        for (int i = 0; i < n; i++) {
            int pos = index[i];
            for (int j = size; j > pos; j--) {
                target[j] = target[j - 1];
            }
            target[pos] = nums[i];
            size++;
        }
        return target;
    }
}
