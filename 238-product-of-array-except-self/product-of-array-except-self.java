class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        int left = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = left;
            left *= arr[i];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= arr[i];
        }
        return ans;
    }
}