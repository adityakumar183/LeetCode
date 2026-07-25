class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> freq = new HashMap<>();
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (freq.containsKey(c)) {
                    freq.put(c, freq.get(c) + 1);
                } else {
                    freq.put(c, 1);
                }

                int maxFreq = 0, minFreq = Integer.MAX_VALUE;
                for (int f : freq.values()) {
                    maxFreq = Math.max(maxFreq, f);
                    minFreq = Math.min(minFreq, f);
                }
                ans += (maxFreq - minFreq);
            }
        }
        return ans;
    }
}