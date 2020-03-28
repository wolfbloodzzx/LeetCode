public class Best_Time_to_Buy_and_Sell_Stock_121 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int s = prices[0];
        int max = 0;
        for(int i = 1; i< prices.length;i++){
            s = s > prices[i] ? prices[i] : s;
            max = max > prices[i] - s ? max : prices[i] - s;
        }
        return max;
    }
    public static void main(String[] args){
        int[] array = new int[]{7};
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_121().maxProfit(array));
    }
}
