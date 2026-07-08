class Solution {
    public int majorityElement(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int ele : arr){
            if(!freq.containsKey(ele)){
                freq.put(ele,1);
            }
            else{
                freq.put(ele, freq.get(ele) + 1);
            }
        }
        int maxFreq = 0;
        int ansKey = -1;
        for(var e : freq.entrySet()){
            if(e.getValue() > maxFreq){
                maxFreq = e.getValue();
                ansKey = e.getKey();
            }
        }
        return ansKey;
    }
}