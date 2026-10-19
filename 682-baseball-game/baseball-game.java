class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            if (s.equals("C")) {
                stack.pop();
            }
            else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
            }
            else if (s.equals("+")) {
                int a = stack.pop();
                int b = stack.peek();
                stack.push(a);
                stack.push(a + b);
            }
            else {
                stack.push(Integer.valueOf(s));
            }
        }
        
        int sum = 0;
        for (int x : stack){
            sum += x;
        }
        return sum;
    }
}
