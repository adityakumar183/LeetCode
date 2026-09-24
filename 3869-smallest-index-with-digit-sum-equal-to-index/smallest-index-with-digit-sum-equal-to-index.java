class Solution {
    public int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public int smallestIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (digitSum(arr[i]) == i) {
                return i;
            }
        }
        return -1;
    }
}