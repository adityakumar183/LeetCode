class Solution {
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int col = 0; col < n; col++) {
            int[] arr = new int[Math.min(m, n - col)];
            int i = 0, j = col, k = 0;

            while (i < m && j < n) {
                arr[k++] = mat[i][j];
                i++;
                j++;
            }

            bubbleSort(arr);

            i = 0;
            j = col;
            k = 0;

            while (i < m && j < n) {
                mat[i][j] = arr[k++];
                i++;
                j++;
            }
        }

        for (int row = 1; row < m; row++) {

            int[] arr = new int[Math.min(m - row, n)];
            int i = row, j = 0, k = 0;

            while (i < m && j < n) {
                arr[k++] = mat[i][j];
                i++;
                j++;
            }

            bubbleSort(arr);

            i = row;
            j = 0;
            k = 0;

            while (i < m && j < n) {
                mat[i][j] = arr[k++];
                i++;
                j++;
            }
        }
        return mat;
    }
}