public class Climbing_Stairs_70 {
    /**
     * 简单DP题
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Climbing_Stairs_70().climbStairs(n));
    }
}
