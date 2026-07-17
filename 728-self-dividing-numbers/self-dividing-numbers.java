class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = left; i <= right;i++){
            int temp = i;
            boolean result = true;
            while (temp > 0) {
                int digit = temp % 10;
                if (digit == 0 || i % digit != 0) {
                    result = false;
                    break;
                }
                temp /= 10;
            }
            if (result) ans.add(i);
        }
        return ans;
    }
}