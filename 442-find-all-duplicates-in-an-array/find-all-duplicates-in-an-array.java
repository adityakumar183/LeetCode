class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : arr) {
            int index = Math.abs(num) - 1;
            if (arr[index] < 0) {
                result.add(Math.abs(num));
            } else {
                arr[index] = -arr[index];
            }
        }
        return result;
    }
}