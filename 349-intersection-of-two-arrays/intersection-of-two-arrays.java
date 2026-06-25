class Solution {
    public int[] intersection(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int[] temp = new int[Math.min(n, m)];
        int k = 0;
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) {
                if (k == 0 || temp[k - 1] != arr1[i]) {
                    temp[k++] = arr1[i];
                }
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[k];
        for (int x = 0; x < k; x++) {
            result[x] = temp[x];
        }
        return result;
    }
}