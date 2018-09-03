import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_II_122 {
    /**
     * 注意不是dp题，就把利润全部累加到一起就可以了
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 0; i< prices.length-1;i++)
            if(prices[i+1] - prices[i] > 0)
                sum += (prices[i+1] - prices[i]);
        return sum;
    }
    public static void main(String[] args){
        int[] array = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(Arrays.toString(array));
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_II_122().maxProfit(array));
    }
}
