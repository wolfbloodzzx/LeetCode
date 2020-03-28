
import java.util.Arrays;

public class Array_Partition_I_561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i< nums.length/2; i++)
            ans += nums[i*2];
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {1,4,3,2};
        System.out.println(new Array_Partition_I_561().arrayPairSum(arr));

    }
}
