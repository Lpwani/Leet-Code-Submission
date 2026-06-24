class Solution {
    public int maxNumberOfBalloons(String text) {

        //counting array version

        int ref[] = new int[26];
        int textOcc[] = new int[26];

        ref['a'-'a'] = 1;
        ref['b' - 'a'] = 1;
        ref['l' - 'a'] = 2;
        ref['o' - 'a'] = 2;
        ref['n' - 'a'] = 1;

        for(int i = 0; i < text.length(); i++){
            textOcc[text.charAt(i) - 'a']++;
        }

        int minAns = Integer.MAX_VALUE;

        for(int i = 0; i < 26; i++){
            if(ref[i] == 0) continue;
            int currOcc = textOcc[i]/ref[i];

            minAns = Math.min(minAns,currOcc); 
        }
    
        return minAns;
    }
}

// System.out.println((int)'a'+" "+(int)'z');
// 97 122


// System.out.println((int)'l' - (int)'a');
// // 11
// System.out.println((int)'o' - (int)'a');
// // 14
// System.out.println((int)'n' - (int)'a');
// // 13