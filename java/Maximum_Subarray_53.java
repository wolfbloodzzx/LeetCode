
public class Maximum_Subarray_53 {
    /**
     * 注意最后的返回结果
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            dp[i] = dp[i - 1] + nums[i] > nums[i] ? dp[i - 1] + nums[i] : nums[i];
        int max = dp[0];
        for (int i = 0; i< dp.length;i++)
            max = max > dp[i] ? max:dp[i];
        return max;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Maximum_Subarray_53().maxSubArray(array));
    }
}
