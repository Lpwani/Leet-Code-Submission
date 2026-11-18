class Solution {
    public String digitSum(String s, int k) {

        // cleaner approach

        String temp = s;
        while(temp.length() > k){
            StringBuilder sb = new StringBuilder();

            for(int ptr = 0; ptr < temp.length(); ptr = ptr+k){

                int end = (ptr + k < temp.length())?ptr + k : temp.length();
                
                int value = 0;

                for(int i = ptr; i < end; i++){
                    value += temp.charAt(i) - '0';
                }

                sb.append(value);
            }

            temp = sb.toString();

        }

        return temp;
        
    }
}