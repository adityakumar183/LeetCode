class Solution {
    public int[][] flipAndInvertImage(int[][] arr) {
        int n = arr.length;
        for (int[] row : arr) {
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] ^= 1;
            }
        }
        return arr;
    }
}