class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (stack.size()>0) sb.append(c);
                stack.push(c);
            } else {
                stack.pop();
                if (stack.size()>0) sb.append(c);
            }
        }
        return sb.toString();
    }
}
