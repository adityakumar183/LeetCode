class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
            else {
                map.put(ch, 1);
            }
        }

        for (char ch : ransomNote.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }
            int count = map.get(ch);
            if (count == 0) {
                return false;
            }
            map.put(ch, count - 1);
        }
        return true;
    }
}