import java.util.Arrays;

public class Decode_Ways_91 {
    /**
     * dp题，主要注意处理好转移方程的条件
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if(s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];
        if(s.charAt(0) == '0')
            dp[0] = 0;
        else
            dp[0] = 1;
        for(int i = 1; i< dp.length;i++){
            char c1 = s.charAt(i - 1), c2 = s.charAt(i);
            dp[i] = 0;
            if(c1 != '0' && Integer.parseInt(""+c1+c2) >0 && Integer.parseInt(""+c1+c2) <=26)
                dp[i] += i-2 < 0 ? 1 : dp[i-2];
            if(Integer.parseInt("" + c2) > 0 && Integer.parseInt("" + c2) <=26)
                dp[i] += dp[i-1];
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()-1];
    }
    public static void main(String[] args){
        String s= "1001";
        System.out.println(new Decode_Ways_91().numDecodings(s));
    }
}
