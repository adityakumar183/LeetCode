class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int count = 0;
        Arrays.sort(costs);
        for(int i =0;i<n;i++){
            if(coins-costs[i] >= 0){
                coins -= costs[i];
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}