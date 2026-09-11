class Solution {
    public int totalNumbers(int[] digits) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int d : digits) {
            if (freq.containsKey(d)) {
                freq.put(d, freq.get(d) + 1);
            } else {
                freq.put(d, 1);
            }
        }

        Set<Integer> result = new HashSet<>();

        for (int num = 100; num <= 999; num++) {
            if (num % 2 != 0) continue;

            int d1 = num / 100;
            int d2 = (num / 10) % 10;
            int d3 = num % 10;

            Map<Integer, Integer> temp = new HashMap<>(freq);

            if (temp.containsKey(d1) && temp.get(d1) > 0) {
                temp.put(d1, temp.get(d1) - 1);

                if (temp.containsKey(d2) && temp.get(d2) > 0) {
                    temp.put(d2, temp.get(d2) - 1);

                    if (temp.containsKey(d3) && temp.get(d3) > 0) {
                        result.add(num);
                    }
                }
            }
        }
        return result.size();
    }
}