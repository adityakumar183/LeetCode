class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumodd = n*n;
        int sumeven = n*n+n;

        while(sumeven != 0){
            int rem = sumodd % sumeven;
            sumodd = sumeven;
            sumeven = rem;
        }
        return sumodd;
    }
}