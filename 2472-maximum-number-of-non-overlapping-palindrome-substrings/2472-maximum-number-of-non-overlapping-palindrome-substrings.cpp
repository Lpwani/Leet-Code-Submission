class Solution {

private:
    bool isPalindrome(const string& s, int i, int j) {
        bool ans = true;
        for (int a = i; a <= j; a++) {
            if (s[a] != s[j - a + i]) {
                ans = false;
                return ans;
            }
        }
        return ans;
    }

    int solve(const string& s, int k, int i, int j, vector<vector<int>>& dp) {
        int n = s.length();
        if (i >= n || j >= n) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (isPalindrome(s, i, j)) {
            int take = 1 + solve(s, k, j + 1, j + k, dp);
            int skip = solve(s, k, i, j + 1, dp);
            int slide = solve(s, k, i + 1, j + 1, dp);

            return dp[i][j] = max(take, max(skip, slide));
        } else {
            int skip = solve(s, k, i, j + 1, dp);
            int slide = solve(s, k, i + 1, j + 1, dp);

            return dp[i][j] = max(skip, slide);
        }
    }

public:
    int maxPalindromes(string s, int k) {
        int n = s.length();
        if (k == 1) return n;

        // Initialize 2D vector with -1, exactly like Arrays.fill in Java
        vector<vector<int>> dp(n, vector<int>(n, -1));

        int ans = solve(s, k, 0, k - 1, dp);
        return ans;
    }
};