
public class Edit_Distance_72 {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        if(l1 == 0 || l2 == 0)
            return l1 > l2 ? l1 : l2;
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++)
            dp[i][0] = i;
        for (int j = 0; j <= l2; j++)
            dp[0][j] = j;

        for (int i = 1; i <= l1; i++)
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    //改
                    int v1 = dp[i - 1][j - 1] + 1;
                    //增
                    int v2 = dp[i][j - 1] + 1;
                    //删
                    int v3 = dp[i - 1][j] + 1;
                    dp[i][j] = (v1 > v2 ? v2 : v1) > v3 ? v3 : (v1 > v2 ? v2 : v1);
                }
            }
//
//            for(int i = 0; i<=l1;i++)
//                System.out.println(Arrays.toString(dp[i]));
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String word1 = "distance", word2 = "springbok";
        System.out.println(new Edit_Distance_72().minDistance(word1, word2));
    }
}
