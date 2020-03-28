import java.util.Arrays;

public class Split_Array_Largest_Sum_410 {
    public int splitArray(int[] nums, int m) {
        if (nums.length < m)
            return 0;
        Arrays.sort(nums);
        int[] container = new int[m - 1];
        for(int i = 0;i< m-1;i++)
            container[i] = nums[i];
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 5, 10, 8};
        System.out.println(new Split_Array_Largest_Sum_410().splitArray(nums, 2));
    }
}
