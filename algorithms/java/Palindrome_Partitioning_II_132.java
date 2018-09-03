import java.util.Arrays;

public class Palindrome_Partitioning_II_132 {
    /**
     * 最长回文字串划分策略，dp题目，注意更新策略
     * @param s
     * @return
     */
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        for (int i = 1; i < dp.length; i++)
            dp[i] = s.length() + 1;
        for (int i = 1; i < dp.length; i++) {
            for (int a = i, b = i; a >= 0 && b < s.length(); a--, b++)
                if (s.charAt(a) == s.charAt(b))
                    if (a == 0)
                        dp[b] = 0;
                    else
                        dp[b] = dp[b] < dp[a - 1] + 1 ? dp[b] : dp[a - 1] + 1;
                else
                    break;
            for (int a = i - 1, b = i; a >= 0 && b < s.length(); a--, b++)
                if (s.charAt(a) == s.charAt(b))
                    if (a == 0)
                        dp[b] = 0;
                    else
                        dp[b] = dp[b] < dp[a - 1] + 1 ? dp[b] : dp[a - 1] + 1;
                else
                    break;

        }
//        System.out.println(Arrays.toString(s.toCharArray()));
//        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        String s = "abbaabaa";
        System.out.println(new Palindrome_Partitioning_II_132().minCut(s));
    }
}
