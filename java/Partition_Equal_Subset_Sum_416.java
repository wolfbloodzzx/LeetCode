import java.util.Arrays;

public class Partition_Equal_Subset_Sum_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        if (sum % 2 != 0)
            return false;
        boolean[] dp = new boolean[sum / 2 + 1];
        for (int i = 0; i < sum / 2 + 1; i++)
            dp[i] = false;
        dp[0] = true;
        for (int n : nums) {
            for (int j = sum /2; j >= n; j--) {
                dp[j] = dp[j] || dp[j - n];
            }
        }
        return dp[sum / 2];
    }

    public static void main(String[] args) {
        int[] f = new int[]{1, 2, 3, 5};
        int[] t = new int[]{1, 5, 11, 5};
        int[] f2 = new int[]{1, 2, 5};
        System.out.println(new Partition_Equal_Subset_Sum_416().canPartition(t));
        System.out.println(new Partition_Equal_Subset_Sum_416().canPartition(f));
        System.out.println(new Partition_Equal_Subset_Sum_416().canPartition(f2));
    }
}
