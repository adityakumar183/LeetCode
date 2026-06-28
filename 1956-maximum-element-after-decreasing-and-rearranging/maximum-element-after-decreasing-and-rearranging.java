class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int maxVal = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= maxVal) {
                maxVal++;
            }
        }
        return maxVal - 1;
    }
}