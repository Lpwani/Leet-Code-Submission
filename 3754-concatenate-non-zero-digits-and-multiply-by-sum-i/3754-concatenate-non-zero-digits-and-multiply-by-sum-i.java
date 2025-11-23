class Solution {
    public long sumAndMultiply(int n) {
        
        String s = Integer.toString(n);
        int N = s.length();

        long curr = 0;
        long tempSum = 0;
        for(int i = 0; i < N; i++){
            if(s.charAt(i) != '0'){
                if(curr == 0){
                    curr = s.charAt(i)-'0';
                    tempSum += s.charAt(i)-'0';
                    System.out.println(curr);
                }
                else{
                    curr = curr * 10 +(s.charAt(i)-'0');
                    tempSum += s.charAt(i)-'0';
                    System.out.println(curr);
                }
            }

        }

        return tempSum*curr;
    }
}