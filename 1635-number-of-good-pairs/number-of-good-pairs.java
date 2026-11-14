class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int result = 0;
        
        for (int x : nums) {
            int count = 0;
            if (freq.containsKey(x)) {
                count = freq.get(x);
            }
            result += count;
            freq.put(x, count + 1);
        }   
        return result;
    }
}
