class Solution {
    public int maximumProduct(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int a = arr[n-1] * arr[n-2] * arr[n-3];
        int b = arr[0] * arr[1] * arr[n-1];
        return Math.max(a,b);
    }
}