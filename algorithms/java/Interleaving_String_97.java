import java.util.Arrays;

public class Interleaving_String_97 {
    /**
     * 很头疼的一道dp题，注意dp表示的含义
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0)
            if (s2.equals(s3)) return true;
            else return false;
        else if (s2.length() == 0)
            if (s1.equals(s3)) return true;
            else return false;
        else if (s1.length() + s2.length() != s3.length())
            return false;
        else {
            int[][] dp = new int[s1.length() + 1][s2.length() + 1];
            dp[0][0] = 1;
            for (int i = 1; i < s1.length()+1; i++)
                dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) ? dp[i - 1][0] : 0;
            for (int j = 1; j < s2.length()+1; j++)
                dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) ? dp[0][j - 1] : 0;
            for (int i = 1; i < s1.length()+1; i++) {
                for (int j = 1; j < s2.length()+1; j++) {
                    if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1] == 1)
                        dp[i][j] = 1;
                    else if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j] == 1)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = 0;
                }
            }
            for (int i = 0; i < s1.length() + 1; i++)
                System.out.println(Arrays.toString(dp[i]));
            if (dp[s1.length()][s2.length()] == 1)
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(new Interleaving_String_97().isInterleave(s1, s2, s3));
    }
}
