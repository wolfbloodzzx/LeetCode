import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class code561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i< nums.length/2; i++)
            ans += nums[i*2];
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {1,4,3,2};
        System.out.println(new code561().arrayPairSum(arr));

    }
}
