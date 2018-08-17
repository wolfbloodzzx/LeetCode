public class _132_Pattern_456 {

    /**
     * dp题，主要考虑一下dp记录的内容，这道题可以参考334题，都是类似的pattern题
     * 但是这个dp记录前边最小的那个
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3)
            return false;
        int[] dp = new int[nums.length];
        dp[0] = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j< i;j++){
                if(nums[i] < nums[j]){
                    if(nums[i] > dp[j])
                        return true;
                }else if (nums[i]> nums[j]){
                    dp[i] = dp[i] > nums[j] ? nums[j] : dp[i];
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = new int[]{0,0,0,0};
        System.out.println(new _132_Pattern_456().find132pattern(test));
    }

}
