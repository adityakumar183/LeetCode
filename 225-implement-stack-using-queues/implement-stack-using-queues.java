class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
        // constructor
    }

    // push efficient method:-
    public void push(int val) {
        q.add(val);
    }
    
    public int pop() {
        for(int i = 1; i <= q.size()-1;i++){
            q.add(q.remove());
        }
        int x = q.peek();
        q.remove();
        return x;
    }
    
    public int top() {
        for(int i = 1; i<=q.size()-1; i++){
            q.add(q.remove());
        }
        int x = q.peek();
        q.add(q.remove());
        return x;
    }
    
    public boolean empty() {
        if(q.size()==0) return true;
        else return false;
    }

    // // POP efficient method:-
    // public void push(int val) {
    //     if(q.size()==0) q.add(val);
    //     else{
    //         q.add(val);
    //         for(int i=1;i<=q.size()-1;i++){
    //             q.add(q.remove());
    //         }
    //     }
    // }
    
    // public int pop() {
    //     return q.remove();
    // }
    
    // public int top() {
    //     return q.peek();
    // }
    
    // public boolean empty() {
    //     if(q.size()==0) return true;
    //     else return false;
    // }
    
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */