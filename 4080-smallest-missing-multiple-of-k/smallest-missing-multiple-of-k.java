class Solution {
    public int missingMultiple(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            set.add(num);
        }

        int multiple = k;
        while(true){
            if(!set.contains(multiple)){
                return multiple;
            }
            multiple += k;
        }
    }
}