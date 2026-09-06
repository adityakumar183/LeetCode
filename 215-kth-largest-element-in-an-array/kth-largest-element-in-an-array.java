class Solution {
    public int findKthLargest(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(freq.keySet());
        keys.sort(Collections.reverseOrder());

        for (int key : keys) {
            k -= freq.get(key);
            if (k <= 0) return key;
        }
        return -1;
    }
}