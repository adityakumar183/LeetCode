class Solution {
    public int countCommas(int n) {
        if (n < 1000) return 0;
        if (n < 10000) return (n - 999);
        if (n < 100000) return (9000) + (n - 9999);
        return (9000) + (90000) + 1;
    }
}