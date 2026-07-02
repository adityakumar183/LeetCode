class MyQueue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    public MyQueue() {
        // Constructor
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        while(st.size()>0){
            temp.push(st.pop());
        }
        int x = temp.pop();
        while(temp.size()>0){
            st.push(temp.pop());
        }
        return x;
    }
    
    public int peek() {
        while(st.size()>0){
            temp.push(st.pop());
        }
        int x = temp.peek();
        while(temp.size()>0){
            st.push(temp.pop());
        }
        return x;
    }
    
    public boolean empty() {
        if(st.size()==0) return true;
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */