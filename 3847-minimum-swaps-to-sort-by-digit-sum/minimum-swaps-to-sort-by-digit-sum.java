class Solution {
    static class Pair {
            int sum, val;
            Pair(int s, int v){
                sum = s;
                val = v;
            }
        }
    public static int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public static int minSwaps(int[] nums) {
        int n = nums.length;

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(digitSum(nums[i]), nums[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.sum != b.sum) return a.sum - b.sum;
            return a.val - b.val;
        });

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.put(arr[i].val, i);
        }

        int swap = 0;
        for (int i = 0; i < n; i++) {
            while (map.get(nums[i]) != i) {
                int correctIndex = map.get(nums[i]);
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
                swap++;
            }
        }
        return swap;
    }
}