class Solution {
    public int maxOperations(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int ops = 0;
        
        for (int num : arr) {
            int complement = k - num;
            if (freq.containsKey(complement) && freq.get(complement) > 0) {
                ops++;
                freq.put(complement, freq.get(complement) - 1);
            } else {
                if (freq.containsKey(num)) {
                    freq.put(num, freq.get(num) + 1);
                } else {
                    freq.put(num, 1);
                }
            }
        }
        return ops;
    }
}