class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int moves = 0;
        for (int i = 1; i < n; i++) {
            moves += arr[i] - arr[0];
        }
        return moves;
    }
}