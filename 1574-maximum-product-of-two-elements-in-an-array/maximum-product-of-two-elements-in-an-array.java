class Solution {
    public int maxProduct(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        return (arr[n-1]-1) * (arr[n-2]-1);
    }
}