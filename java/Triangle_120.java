import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_120 {
    /**
     * DP题，解法一：二维dp
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        else if (triangle.size() == 0)
            return 0;
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (j - 1 < 0)
                    dp[i][j] = dp[i - 1][j] + row.get(j);
                else if (j + 1 >= triangle.get(i - 1).size())
                    dp[i][j] = dp[i - 1][j - 1] + row.get(j);
                else
                    dp[i][j] = dp[i - 1][j] < dp[i - 1][j - 1] ? dp[i - 1][j] + row.get(j) : dp[i - 1][j - 1] + row.get(j);
            }
        }
        int min = dp[triangle.size()-1][0];
        for(int v : dp[triangle.size()-1])
            min = min < v?min:v;
        for(int i = 0;i<dp.length;i++)
            System.out.println(Arrays.toString(dp[i]));
        return min;
    }

    /**
     * 解法2：一维dp，其实也是二维的，只不过dp数组的含义变化了，倒着dp
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for(int i = triangle.size() - 1; i >= 0;i--){
            List<Integer> row = triangle.get(i);
            for(int j = 0; j< row.size();j++){
                if(i == triangle.size()-1)
                    dp[j] = row.get(j);
                else
                    dp[j] = (dp[j] < dp[j+1] ? dp[j] : dp[j+1]) +row.get(j);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> t = new ArrayList<>();
        t.add(Arrays.asList(new Integer[]{-1}));
        t.add(Arrays.asList(new Integer[]{3, 4}));
        t.add(Arrays.asList(new Integer[]{1, -2, -1}));
//        t.add(Arrays.asList(new Integer[]{ 1, 10, 8, 3}));
        System.out.println(new Triangle_120().minimumTotal(t));
        System.out.println(new Triangle_120().minimumTotal2(t));
    }
}
