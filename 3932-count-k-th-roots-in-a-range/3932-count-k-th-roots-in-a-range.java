class Solution {
    public int countKthRoots(int l, int r, int k) {

        long left = kthRootCeil(l,k);
        long right = kthRootFloor(r,k);

        if(left > right){
            return 0;
        }

        return (int)(right - left + 1);
    }

    public long kthRootFloor(long n, int k){
        long low = 0, high = 1000000000L;

        while(low <= high){
            long mid = low + (high - low)/2;

            if(power(mid,k,n) <= n){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return high;
    }

    public long kthRootCeil(long n, int k){
        long floor = kthRootFloor(n,k);

        if(power(floor, k, n) == n){
            return floor;
        }

        return floor + 1;
    }


    public long power(long base, int exp, long lim){
        long result = 1;

        for(int i = 0; i < exp; i++){
            if(base != 0 && result > lim/base){
                return lim+1;
            }

            result *= base;
        }

        return result;
    }
}