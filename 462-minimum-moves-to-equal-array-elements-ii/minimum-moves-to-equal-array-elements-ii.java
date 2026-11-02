class Solution {
    public int minMoves2(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int mid = n / 2;
        int moves = 0;

        for (int num : arr) {
            moves += Math.abs(num - arr[mid]);
        }
        return moves;
    }
}
