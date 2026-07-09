class Solution {
    public int distributeCandies(int[] candyType) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : candyType) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return Math.min(map.size(), candyType.length / 2);
    }
}