class Solution {
    public List<List<Integer>> shiftGrid(int[][] arr, int k) {
        int m = arr.length;
        int n = arr[0].length;
        int total = m * n;
        k = k % total;

        int[] newArr = new int[total];
        int idx = 0;
        for (int[] row : arr) {
            for (int val : row) {
                newArr[idx++] = val;
            }
        }

        int[] rotated = new int[total];
        for (int i = 0; i < total; i++) {
            rotated[(i + k) % total] = newArr[i];
        }

        List<List<Integer>> result = new ArrayList<>();
        idx = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(rotated[idx++]);
            }
            result.add(row);
        }
        return result;
    }
}