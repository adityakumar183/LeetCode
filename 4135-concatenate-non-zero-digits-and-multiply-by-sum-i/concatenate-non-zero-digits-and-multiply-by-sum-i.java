class Solution {
    public long sumAndMultiply(int n) {
        int x = 0;
        int sum = 0;
        int multiplier = 1;
        
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit != 0) {
                x = digit * multiplier + x;
                sum += digit;
                multiplier *= 10;
            }
            temp /= 10;
        }
        
        if (multiplier == 1) return 0;
        return (long)x * sum;
    }
}