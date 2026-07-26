class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums1) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (freq.containsKey(num) && freq.get(num) > 0) {
                list.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}