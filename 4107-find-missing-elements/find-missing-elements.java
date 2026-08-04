class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int min = arr[0];
        int max = arr[arr.length-1];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = min;i<=max;i++){
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}