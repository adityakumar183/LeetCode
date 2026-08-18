class Solution {
    public int largestInteger(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;

        for(int i = 0; i <= n-k; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i; j<i+k; j++){
                set.add(arr[j]);
            }

            for(int x : set){
                if(map.containsKey(x)){
                    map.put(x , map.get(x)+1);
                }
                else{
                    map.put(x,1);
                }
            }
        }

        int ans = -1;
        for(int x : map.keySet()){
            if(map.get(x)==1){
                ans = Math.max(ans,x);
            }
        }
        return ans;
    }
}