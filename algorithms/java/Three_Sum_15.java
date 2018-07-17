import java.util.*;

public class Three_Sum_15 {
    /**
     * 这道题目的思路类似TwoSum，先排序后选从最小开始遍历，剩下的就是个TwoSum的问题
     * 同时这个输出要求的是输出结果，不是id，所以更适合基于搜索来做。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<String> temp = new HashSet<>();     //去重用的
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = 0 - nums[i];
            int id1 = i + 1, id2 = nums.length - 1;
            while (id1 != id2) {
                if (nums[id1] + nums[id2] < target)
                    id1++;
                else if (nums[id1] + nums[id2] > target)
                    id2--;
                    // 这块还得考虑去个重。。
                else if (id1 != id2) {
                    String label = "" + nums[i] + "_" + nums[id1] + "_" + nums[id2];
                    if (!temp.contains(label)) {
                        List<Integer> t = Arrays.asList(new Integer[]{nums[i], nums[id1], nums[id2]});
                        result.add(t);
                        temp.add(label);
                    }
                    id1++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{-2, 0, 1, 1, 2};
        Three_Sum_15 solution = new Three_Sum_15();
        System.out.println(solution.threeSum(nums));
    }
}
