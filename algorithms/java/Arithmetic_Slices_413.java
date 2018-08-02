
public class Arithmetic_Slices_413 {

    /**
     * DP题目，dp记录当前位置到前边最长的arithmetic片段
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3)
            return 0;
        int[] dp = new int[A.length];
        dp[0] = 0;
        dp[1] = 0;
        int result = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2])
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = 0;
            result += dp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4};
        System.out.println(new Arithmetic_Slices_413().numberOfArithmeticSlices(test));
    }
}
