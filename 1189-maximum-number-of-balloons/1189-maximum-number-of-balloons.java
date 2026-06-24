class Solution {
    public int maxNumberOfBalloons(String text) {


        // generalized hashmap version solution

        HashMap<Character, Integer> ref = new HashMap<>();

        ref.put('b',1);
        ref.put('a', 1);
        ref.put('l', 2);
        ref.put('o', 2);
        ref.put('n', 1);

        HashMap<Character, Integer> txtMp =  new HashMap<>();

        for(int i = 0; i < text.length(); i++){
            char curr = text.charAt(i);
            txtMp.put(curr,txtMp.getOrDefault(curr,0)+1);
        }

        int minOcc = Integer.MAX_VALUE;
        for(char key : ref.keySet()){
            int occ = txtMp.getOrDefault(key,0)/ref.get(key);

            minOcc = Math.min(occ,minOcc);
        }

        return minOcc;
    }
}