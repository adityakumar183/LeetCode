class Solution {
    public int[] twoSum(int[] arr, int target) {
        int[] ans = {-1,-1};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length;i++){
            int remaining = target - arr[i];
            if(map.containsKey(remaining)){
                ans[0] = i;
                ans[1] = map.get(remaining);
                break;
            }
            else{
                map.put(arr[i],i);
            }
        }
        return ans;
    }
}