class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        // Method 01:-
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0; i<a.length; i++){
            if(a[i] != b[i]) return false;
        }
        return true;

        // Method 02:-
        // Map<Character, Integer> Smap = new HashMap<>();
        // for(int i = 0; i<s.length();i++){
        //     char key = s.charAt(i);
        //     if(Smap.containsKey(key)){
        //         int freq = Smap.get(key);
        //         Smap.put(key,freq+1);
        //     }
        //     else{
        //         Smap.put(key,1);
        //     }
        // }

        // Map<Character, Integer> Tmap = new HashMap<>();
        // for(int i = 0; i<t.length();i++){
        //     char key = t.charAt(i);
        //     if(Tmap.containsKey(key)){
        //         int freq = Tmap.get(key);
        //         Tmap.put(key,freq+1);
        //     }
        //     else{
        //         Tmap.put(key,1);
        //     }
        // }

        // for(char key : Smap.keySet()){
        //     int val1 = Smap.get(key);
        //     if(!Tmap.containsKey(key)) return false;
        //     int val2 = Tmap.get(key);
        //     if(val1 != val2) return false;
        // }
        // return true;
    }
}