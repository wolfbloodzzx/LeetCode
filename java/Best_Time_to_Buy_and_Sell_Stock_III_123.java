import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_III_123 {
    /**
     * 这个才是dp题
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];
        for(int i = 0;i<prices.length;i++){
            int min = prices[0];
            int max = 0;
            for(int j = 0; j <= i; j++){
                min = min < prices[j] ? min : prices[j];
                max = prices[j] - min > max ? prices[j] - min : max;
            }
            dp1[i] = max;
            min = prices[i];
            max = 0;
            for(int j = i;j<prices.length;j++){
                min = min < prices[j] ? min : prices[j];
                max = prices[j] - min > max ? prices[j] - min : max;
            }
            dp2[i] = max;
        }
        int result = 0;
        for(int i = 0; i < prices.length; i ++ )
            result = result > dp1[i] + dp2[i] ? result : dp1[i] + dp2[i];
        return result;
    }

    public static void main(String[] args){
        int[] array = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(Arrays.toString(array));
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_III_123().maxProfit(array));
    }
}
