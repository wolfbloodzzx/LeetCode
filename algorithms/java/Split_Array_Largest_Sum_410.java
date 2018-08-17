import java.util.Arrays;

public class Split_Array_Largest_Sum_410 {
    public int splitArray(int[] nums, int m) {
        if (nums.length < m)
            return 0;
        Arrays.sort(nums);
        int[] container = new int[m - 1];
        for (int i = nums.length - m + 1; i < nums.length; i++)
            container[i - nums.length + m - 1] = nums[i];
        int end = nums.length - m + 1;
        int sum = nums[0];
        while (end > 0) {
            sum = 0;
            for (int i = 0; i < end; i++)
                sum += nums[i];
            if (sum < container[0])
                break;
            container[0] += nums[end - 1];
            Arrays.sort(container);
            end -= 1;
        }
        if (end == 0)
            return nums[0];
        else
            return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 5, 10, 8};
        System.out.println(new Split_Array_Largest_Sum_410().splitArray(nums, 2));
    }
}
