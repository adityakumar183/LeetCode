class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int revIndex = 'z' - s.charAt(i) + 1;
            sum += revIndex * (i + 1);
        }
        return sum;
    }
}