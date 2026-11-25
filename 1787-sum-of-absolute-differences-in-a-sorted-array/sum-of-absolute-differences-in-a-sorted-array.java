class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = total - leftSum - nums[i];
            int left = nums[i] * i - leftSum;
            int right = rightSum - nums[i] * (n - i - 1);
            ans[i] = left + right;
            leftSum += nums[i];
        }
        return ans;
    }
}