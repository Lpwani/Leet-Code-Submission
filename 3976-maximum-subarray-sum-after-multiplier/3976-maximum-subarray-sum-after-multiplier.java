class Solution {

    public long solve(int[] nums, long[] temp) {

        // maintain 3 dp states
        // 1) not in modified state
        // 2) currently in modifing state
        // 3) passed the modifing state

        int n = nums.length;

        long INF = (long) 1e16;

        long s1 = nums[0];
        long s2 = temp[0];
        long s3 = -INF;

        long maxAns = Math.max(s1, s2);

        // long n1 = Long.MIN_VALUE;
        // long n2 = Long.MIN_VALUE;
        // long n1 = Long.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            long n1 = nums[i];
            long n2 = temp[i];

            long s3next = Math.max(s3 + n1, s2 + n1);

            long s2maxcomp1 = Math.max(n2, s1 + n2);
            long s2next = Math.max(s2maxcomp1, s2 + n2);

            long s1next = Math.max(n1, s1 + n1);

            s1 = s1next;
            s2 = s2next;
            s3 = s3next;

            long scomp = Math.max(s1, maxAns);
            long scomp2 = Math.max(scomp, s2);
            maxAns = Math.max(scomp2, s3);

        }

        // long scomp = Math.max(s1,s2);

        return maxAns;
    }

    public long maxSubarraySum(int[] nums, int k) {

        int n = nums.length;

        long multi[] = new long[n];
        long div[] = new long[n];

        for (int i = 0; i < n; i++) {
            long curr = 1l * nums[i] * k;
            multi[i] = curr;
            if (nums[i] < 0) {
                curr = 1l * (long) Math.ceil((double) nums[i] / k);
            } else {
                curr = 1l * (long) Math.floor((double) nums[i] / k);
            }
            div[i] = curr;
        }

        long mulOpMax = solve(nums, multi);
        long divOpMax = solve(nums, div);

        long ans = Math.max(mulOpMax, divOpMax);

        return ans;

    }

}