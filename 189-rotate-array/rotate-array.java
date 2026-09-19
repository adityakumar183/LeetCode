class Solution {
    public void rotate(int[] nums, int k) {
    int n = nums.length;
    k %= n;
    int[] temp = new int[n];
    for (int i = 0; i < k; i++) temp[i] = nums[n-k+i];
    for (int i = k; i < n; i++) temp[i] = nums[i-k];
    System.arraycopy(temp, 0, nums, 0, n);
}

}