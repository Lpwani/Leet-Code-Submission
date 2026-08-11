class Solution {

    // Returns the smallest 'length'-digit string
    // whose digit product is divisible by 'required'.
    private String freeSlotsFiller(long required, int length) {

        StringBuilder str = new StringBuilder();

        // Try larger digits first so that we can
        // compress the prime factors into fewer digits.
        for (int digit = 9; digit >= 2; digit--) {

            while (required % digit == 0) {
                str.append((char) ('0' + digit));
                required /= digit;
            }
        }

        // Some factor cannot be represented using
        // digits 1 to 9.
        if (required != 1) {
            return "";
        }

        // Fill remaining positions with 1.
        while (str.length() < length) {
            str.append('1');
        }

        // Arrange digits in increasing order to obtain
        // the smallest possible suffix.
        str.reverse();

        return str.toString();
    }

    // Euclidean algorithm
    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public String smallestNumber(String num, long t) {

        int n = num.length();

        // --------------------------------------------------
        // Step 1: Check whether t can be represented using
        // factors available in digits 1..9.
        //
        // Possible prime factors:
        // 2, 3, 5, 7
        // --------------------------------------------------

        long temp = t;

        int[] primeFactors = {2, 3, 5, 7};

        for (int primeFact : primeFactors) {

            while (temp % primeFact == 0) {
                temp /= primeFact;
            }
        }

        // t contains a prime factor other than 2,3,5,7
        if (temp != 1) {
            return "-1";
        }

        // --------------------------------------------------
        // Step 2: Precompute remaining factors.
        //
        // remainingFactor[i] =
        // factor of t still required after using
        // the first i digits.
        // --------------------------------------------------

        long[] remainingFactor = new long[n + 1];

        Arrays.fill(remainingFactor, t);

        for (int i = 0; i < n; i++) {

            int digit = num.charAt(i) - '0';

            // Cannot keep a prefix containing zero.
            if (digit == 0) {
                break;
            }

            remainingFactor[i + 1] =
                    remainingFactor[i]
                    / gcd(remainingFactor[i], digit);
        }

        // --------------------------------------------------
        // Step 3: num itself can be returned only if:
        //
        // 1. It is zero-free
        // 2. Its digit product is divisible by t
        // --------------------------------------------------

        if (num.indexOf('0') == -1 && remainingFactor[n] == 1) {
            return num;
        }

        // --------------------------------------------------
        // Step 4: Find the first zero.
        // --------------------------------------------------

        int zeroPos = num.indexOf('0');

        int zeroIdx = n - 1;

        if (zeroPos != -1) {
            zeroIdx = zeroPos;
        }

        // --------------------------------------------------
        // Step 5: Change a digit from right to left.
        //
        // IMPORTANT:
        // The replacement digit must be STRICTLY greater
        // than the original digit.
        //
        // Otherwise, we could create a number smaller
        // than num.
        // --------------------------------------------------

        for (int i = zeroIdx; i >= 0; i--) {

            long required = remainingFactor[i];

            int freeSlots = n - 1 - i;

            int currentDigit = num.charAt(i) - '0';

            // We are changing this position, so the new
            // digit must be strictly greater.
            //
            // If currentDigit = 0, this starts from 1.
            int startDigit = currentDigit + 1;

            for (int digit = startDigit; digit <= 9; digit++) {

                long furtherRequired =
                        required / gcd(required, digit);

                String requiredNumber =
                        freeSlotsFiller(
                                furtherRequired,
                                freeSlots
                        );

                // We found a valid suffix.
                if (requiredNumber.length() == freeSlots) {

                    return num.substring(0, i)
                            + (char) ('0' + digit)
                            + requiredNumber;
                }
            }
        }

        // --------------------------------------------------
        // Step 6: No valid number of length n exists.
        //
        // Construct the smallest valid number with n+1
        // digits.
        // --------------------------------------------------

        return freeSlotsFiller(t, n + 1);
    }
}


// String freeSlotsFiller(int required, int length){
    //     String str;

    //     for(int digit = 9; digit >= 2; digit--){
    //         while(required % digit == 0){
    //             str.push_back(digit + '0');
    //             required /= digit;
    //         }
    //     }

    //     while(str.length() < length){
    //         str.push_back('1');
    //     }

    //     reverse(begin(str), end(str));

    //     return str;
    // }

    // public String smallestNumber(String num, long t) {
    //     int n = num.length;

    //     long temp = t;
    //     for(int  primeFact : {2,3,5,7}) {
    //         while(temp % primeFact == 0){
    //             temp /= primeFact;
    //         }
    //     }

    //     if(temp != 1){
    //         return '-1';
    //     }

    //     // precompute remainingFactor[i] = if we take i digits of num in my result, what factor remaining for making it divisible by t

    //     long remainingFactor[] = new int[n+1];
    //     Arrays.fill(remainingFactor, t);

    //     for(int i = 0; i < n; i++){
    //         int digit = num[i]-'0';

    //         if(digit == 0){
    //             break;
    //         }

    //         remainingFactor[i+1] = remainingFactor[i]/gcd(remainingFactor[i],(long)digit);
    //     }

    //     if(remainingFactor[n] == 1){
    //         return num;
    //     }

    //     int zeroPos = num.find('0');
    //     int zeroIdx = n-1;
    //     if(zeroPos != -1){
    //         zeroIdx = zeroPos;
    //     }

    //     for(int i = zeroIdx; i >= 0; i--){
    //         long required = remainingFactor[i];

    //         int freeSlots = n-1-i;

    //         for(int digit = (num[i] - '0'); digit <= '9'; digit++){
    //             int furtherRequired = required/ gccd(required, digit);
    //             String requiredNumber = freeSlotsFiller(furtherRequired, freeSlots);

    //             if(requiredNumber.length() == freeSlots) {
    //                 return num.substring(0,i) + (char)(digit+'0')+requiredNumber;
    //             }
    //         }
    //     }

    //     return freeSlotsFiller(t, n+1);
    // }