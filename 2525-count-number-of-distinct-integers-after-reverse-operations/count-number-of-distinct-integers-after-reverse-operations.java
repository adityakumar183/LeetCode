class Solution {
    public int rev(int x){
        int r = 0;
        while(x!=0){
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }
    public int countDistinctIntegers(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i= 0;i<arr.length;i++){
            set.add(arr[i]);
            set.add(rev(arr[i]));
        }
        return set.size();
    }
}