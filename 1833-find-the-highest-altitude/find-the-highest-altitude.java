class Solution {
    public int largestAltitude(int[] gain) {
        int currAltitude = 0;
        int maxAltitude = 0;
        for(int i = 0; i<gain.length; i++){
            currAltitude += gain[i];
            if(currAltitude > maxAltitude){
                maxAltitude = currAltitude;
            }
        }
        return maxAltitude;
    }
}