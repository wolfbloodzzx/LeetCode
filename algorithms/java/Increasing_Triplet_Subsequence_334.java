public class Increasing_Triplet_Subsequence_334 {
    /**
     * 经典的dp题
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i])
                    dp[i] = dp[i] > (dp[j] + 1) ? dp[i] : dp[j] + 1;
            if(dp[i] == 3)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,3,2,1};
        System.out.println((new Increasing_Triplet_Subsequence_334()).increasingTriplet(nums));
    }
}
