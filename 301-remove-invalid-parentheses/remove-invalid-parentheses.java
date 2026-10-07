class Solution {
    public void helper(String s, int start, int left, int right, Set<String> res) {
        if (left == 0 && right == 0) {
            if (isValid(s)) res.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) continue;
            if (s.charAt(i) == '(' && left > 0) {
                helper(s.substring(0, i) + s.substring(i + 1), i, left - 1, right, res);
            }
            if (s.charAt(i) == ')' && right > 0) {
                helper(s.substring(0, i) + s.substring(i + 1), i, left, right - 1, res);
            }
        }
    }

    public boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
    
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        Set<String> res = new HashSet<>();
        helper(s, 0, left, right, res);
        return new ArrayList<>(res);
    }
}
