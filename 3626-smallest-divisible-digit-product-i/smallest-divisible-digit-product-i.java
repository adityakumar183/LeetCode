class Solution {
    public int digitProduct(int x) {
        int product = 1;
        while (x > 0) {
            product *= (x % 10);
            x /= 10;
        }
        return product;
    }
    public int smallestNumber(int n, int t) {
        while (true) {      // while(true)-> infinite loop.keeps running until we return a value.
            int product = digitProduct(n);
            if (product % t == 0) return n;
            n++;
        }
    }
}
