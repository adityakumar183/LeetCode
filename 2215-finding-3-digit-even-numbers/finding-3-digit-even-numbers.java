class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int d : digits) {
            freq.put(d, freq.getOrDefault(d, 0) + 1);
        }

        Set<Integer> result = new HashSet<>();

        for (int num = 100; num <= 999; num++) {
            if (num % 2 != 0) continue; 

            int d1 = num / 100;
            int d2 = (num / 10) % 10;
            int d3 = num % 10;

            Map<Integer, Integer> temp = new HashMap<>(freq);
            if (temp.getOrDefault(d1, 0) > 0) {
                temp.put(d1, temp.get(d1) - 1);
                if (temp.getOrDefault(d2, 0) > 0) {
                    temp.put(d2, temp.get(d2) - 1);
                    if (temp.getOrDefault(d3, 0) > 0) {
                        result.add(num);
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>(result);
        Collections.sort(list);
        return list.stream().mapToInt(x -> x).toArray();
    }
}