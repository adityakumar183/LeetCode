class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertions = 0;
        int n = s.length();
        int i = 0;
        
        while (i < n) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push('(');
                i++;
            } else {
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    if (stack.size() > 0) stack.pop();
                    else insertions++;
                    i += 2;
                } else {
                    insertions++;
                    if (stack.size() > 0) stack.pop();
                    else insertions++;
                    i++;
                }
            }
        }  
        return insertions + 2 * stack.size();
    }
}
