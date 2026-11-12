class Solution {
    public int longestMonotonicSubarray(int[] arr) {
        int n = arr.length;
        int max = 1;

        for (int i = 0; i < n; i++) {
            int inc = 1;
            int dec = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[j - 1]) {
                    inc++;
                    dec = 1;
                }
                else if (arr[j] < arr[j - 1]) {
                    dec++;
                    inc = 1;
                }
                else {
                    break;
                }
                max = Math.max(max, Math.max(inc, dec));
            }
        }
        return max;
    }
}