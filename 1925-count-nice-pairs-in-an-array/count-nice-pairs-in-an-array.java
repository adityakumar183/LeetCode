class Solution {
    public int rev(int x){
        int r = 0;
        while(x!=0){
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }

    public int countNicePairs(int[] arr) {
        // Method 01:- T.C=O(n^2)
        // int count = 0;
        // int n = arr.length;
        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(arr[i] + rev(arr[j]) == arr[j] + rev(arr[i])){
        //             count++;
        //         }
        //     }
        // }
        // return count;

        // Method 02:- T.C=O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i =0;i<arr.length;i++){
            int ele = arr[i]-rev(arr[i]);
            if(map.containsKey(ele)){
                int freq = map.get(ele);
                count += freq;
                count %= 1000000007;
                map.put(ele,freq+1);
            }
            else map.put(ele,1);
        }
        return count;
    }
}