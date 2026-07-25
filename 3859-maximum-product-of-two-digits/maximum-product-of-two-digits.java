class Solution {
    public int maxProduct(int n) {
       int firstMax = -1;
       int secondMax = -1;
        
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            
            if (digit > firstMax) {
                secondMax = firstMax;
                firstMax = digit;
            }
            else if (digit > secondMax) {
                secondMax = digit;
            }
        }   
        return firstMax * secondMax; 
    }
}