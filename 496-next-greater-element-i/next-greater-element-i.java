class Solution {
    public int[] nextGreaterElement(int[] arr1, int[] arr2) {
        int n = arr2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            while(st.size()>0 && st.peek() <= arr2[i]){
                st.pop();
            }  
            if(st.size()==0){
                map.put(arr2[i], -1);
            }
            else{
                map.put(arr2[i], st.peek());
            }
            st.push(arr2[i]);
        }

        int[] ans = new int[arr1.length];
        for(int i = 0; i< arr1.length; i++){
            ans[i] = map.get(arr1[i]);
        }
        return ans;
    }
}