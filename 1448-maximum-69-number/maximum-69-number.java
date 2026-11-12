class Solution {
    public int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public int maximum69Number (int num) {
        int digits = countDigits(num);

        int[] arr = new int[digits];
        int temp = num;
        for (int i = digits - 1; i >= 0; i--) {
            arr[i] = temp % 10;
            temp /= 10;
        }

        for (int i = 0; i < digits; i++) {
            if (arr[i] == 6) {
                arr[i] = 9;
                break;
            }
        }

        int ans = 0;
        for (int i = 0; i < digits; i++) {
            ans = ans * 10 + arr[i];
        }
        return ans;
    }
}
