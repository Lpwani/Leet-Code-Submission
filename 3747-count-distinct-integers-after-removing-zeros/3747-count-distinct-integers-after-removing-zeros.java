class Solution {

    private long pow9(int p){
        long ans = 1;

        for(int i = 1; i <= p; i++){
            ans *= 9;
        }
        return ans;
    }

    private boolean isPow10(long n){
        long temp = n;

        while(temp >= 10 && temp%10 == 0){
            temp /= 10;
        }
        if(temp == 1){
            System.out.println("true");
            return true;
        }
        else return false;
    }

    public long countDistinct(long n) {

        String s = String.valueOf(n);
        int len = s.length();

        long ans = 0;

        // count numbers with fewer digits than n
        for (int digits = 1; digits < len; digits++) {
            ans += pow9(digits);
        }

        // now process digit by digit for numbers with same length
        boolean tight = true;

        for (int i = 0; i < len; i++) {
            int currDigit = s.charAt(i) - '0';

            if (currDigit == 0) {
                // if digit becomes zero, no further valid numbers exist
                tight = false;
                break;
            }

            // count digits smaller than currDigit but ≥ 1
            int choices = currDigit - 1;

            ans += choices * pow9(len - i - 1);
        }

        // if tight remained true, the number n itself has no zero → count it
        if (tight) ans += 1;

        return ans;
    }
}

