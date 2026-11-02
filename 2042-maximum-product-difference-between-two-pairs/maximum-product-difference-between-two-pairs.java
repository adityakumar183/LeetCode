class Solution {
    public int maxProductDifference(int[] arr) {
        Arrays.sort(arr);
        int n =arr.length;

        int maxProduct = arr[n - 1] * arr[n - 2];
        int minProduct = arr[0] * arr[1];

        return maxProduct - minProduct;
    }
}
