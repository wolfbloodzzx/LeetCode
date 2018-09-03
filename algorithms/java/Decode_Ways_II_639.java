import java.util.Arrays;

public class Decode_Ways_II_639 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if(s.charAt(0) == '0')
            dp[0] = 0;
        else if(s.charAt(0) == '*')
            dp[0] = 9;
        else
            dp[0] = 1;
        for(int i = 1;i<s.length();i++){
            char c1 = s.charAt(i-1), c2 = s.charAt(i);
            dp[i] = 0;
            if(c1 != '*' && c2 != '*'){
                if(c1 > '0')
                    dp[i] += dp[i-1];
                if(c2 > '0' && Integer.parseInt(""+c1+c2) >0 && Integer.parseInt(""+c1+c2)<=26)
                    dp[i] += i-2 >= 0 ? dp[i-2] : 1;
            }else if(c1 == '*' && c2 == '*'){
                dp[i] += 9 * dp[i-1];
                dp[i] += 15 * (i-2 >= 0 ? dp[i-2] : 1);
            }else if(c2 == '*'){
                dp[i] += 9 * dp[i-1];
                if(c1 == '1')
                    dp[i] += 9*(i-2 >= 0 ? dp[i-2] : 1);
                if(c1 == '2')
                    dp[i] += 6*(i-2 >= 0 ? dp[i-2] : 1);
            }else if(c1 == '*'){
                if(c2 >= '0' && c2<='6')
                    dp[i] += dp[i - 1] + 2*(i-2 >= 0 ? dp[i-2] : 1);
                if(c2 > '6')
                    dp[i] += dp[i - 1] + (i-2 >= 0 ? dp[i-2] : 1);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length() -1];
    }

    public static void main(String[] args){
        String test = "*1*1*0";
        System.out.println(new Decode_Ways_II_639().numDecodings(test));
    }
}
