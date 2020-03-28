public class House_Robber_II_213 {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length <= 3){
            int max = -1;
            for(int i : nums)
                max = max > i ? max: i;
            return max;
        }
        int tmp_max = 0;
        int start = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[1][0] = start; dp[1][1] = 0;
        for(int i = 2; i< nums.length;i++){
            dp[i][1] = dp[i-1][0] + nums[i];
            dp[i][0] = dp[i-1][0] > dp[i-1][1] ? dp[i-1][0] : dp[i-1][1];
        }
        tmp_max = dp[nums.length - 1][0];

        start = 0;
        dp[1][0] = 0; dp[1][1] = nums[1];
        for(int i = 2; i< nums.length;i++){
            dp[i][1] = dp[i-1][0] + nums[i];
            dp[i][0] = dp[i-1][0] > dp[i-1][1] ? dp[i-1][0] : dp[i-1][1];
        }
        int tmp_max2 = (dp[nums.length - 1][1] > dp[nums.length-1][0]?
                dp[nums.length-1][1]:dp[nums.length-1][0]);
        return tmp_max > tmp_max2 ? tmp_max : tmp_max2;
    }
    public static void main(String[] args){
        int[] test = new int[]{1,2,3,1};
        System.out.println(new House_Robber_II_213().rob(test));
    }
}
