public class House_Robber_198 {
    /**
     * dp题，典型的二维dp，根据上一个状态专业，不难
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;dp[0][1] = nums[0];
        for(int i = 1;i< nums.length;i++){
            dp[i][0] = dp[i-1][0] > dp[i-1][1] ? dp[i-1][0] : dp[i-1][1];
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return dp[nums.length - 1][0]> dp[nums.length -1][1] ?
                dp[nums.length - 1][0]: dp[nums.length - 1][1];
    }
    public static void main(String[] args){
        int[] test = new int[]{1,2,3,1};
        System.out.println(new House_Robber_198().rob(test));
    }
}
