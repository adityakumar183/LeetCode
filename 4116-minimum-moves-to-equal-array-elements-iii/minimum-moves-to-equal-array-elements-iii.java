class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int moves = 0;
        
        for(int i=0;i<n;i++){
            if(arr[i]!=arr[n-1]){
                moves += arr[n-1]-arr[i];
            }
        }
        return moves;
    }
}
