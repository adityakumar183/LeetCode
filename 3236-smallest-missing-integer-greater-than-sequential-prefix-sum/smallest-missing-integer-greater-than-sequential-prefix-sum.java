class Solution {
    public int missingInteger(int[] arr) {
        int i = 0;
        while(i+1 < arr.length && arr[i+1] == arr[i]+1){
            i++;
        }

        int prefixsum = 0;
        for(int j = 0; j <= i; j++){
            prefixsum += arr[j];
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr){
            set.add(num);
        }

        while (set.contains(prefixsum)) {
            prefixsum++;
        }
        return prefixsum;
    }
}