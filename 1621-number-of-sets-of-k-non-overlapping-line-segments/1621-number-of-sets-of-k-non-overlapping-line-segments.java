class Solution {
    public int numberOfSets(int n, int k) {
        if (n - 1 < k) {
            return 0;
        }
        int[] dp = new int[k + 1];
        int[] sum = new int[k + 1];
        dp[0] = 1;
        sum[0] = 1;
        int mod = 1000000007;
        for (int i = 1; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                dp[j] = (dp[j] + sum[j - 1]) % mod;
                sum[j] = (sum[j] + dp[j]) % mod;
            }
            sum[0] = (sum[0] + dp[0]) % mod;
        }
        return dp[k];
    }
}
