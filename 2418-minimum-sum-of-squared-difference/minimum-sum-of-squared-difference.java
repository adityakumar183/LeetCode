class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diffs = new int[n];
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diffs[i]);
        }

        long k = (long) k1 + k2;

        int left = 0, right = maxDiff;
        while (left < right) {
            int mid = (left + right) / 2;
            long ops = 0;
            for (int d : diffs) {
                if (d > mid) ops += d - mid;
                if (ops > k) break;
            }
            if (ops <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long opsUsed = 0;
        for (int i = 0; i < n; i++) {
            if (diffs[i] > left) {
                opsUsed += diffs[i] - left;
                diffs[i] = left;
            }
        }

        long leftover = k - opsUsed;
        Arrays.sort(diffs);
        for (int i = n - 1; i >= 0 && leftover > 0; i--) {
            if (diffs[i] > 0) {
                diffs[i]--;
                leftover--;
            }
        }

        long result = 0;
        for (int d : diffs) {
            result += (long) d * d;
        }
        return result;
    }
}