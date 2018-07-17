import java.util.*;

public class Two_Sum_1 {
    /**
     * 方法一： 通过Hash来做
     * 空间复杂度：O(n)
     * 时间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other))
                if(i > map.get(other))
                    return new int[]{map.get(other), i};
                else
                    return new int[]{i, map.get(other)};
        }
        return new int[]{};
    }
    /**
     * 方法二： 通过搜索来做
     * 大体思路是先排序，然后两个指针，一个从头走，一个从后走来进行搜索，但是这道题由于是要输出id，所以单纯这样做比较麻烦
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target){
        List<int[]> temp = new ArrayList<>();
        for(int i = 0;i< nums.length;i++)
            temp.add(new int[]{i, nums[i]});
        Collections.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return ((Integer)o1[1]).compareTo((Integer)o2[1]);
            }
        });
        int i = 0, j = temp.size() - 1;
        while(temp.get(i)[1] + temp.get(j)[1] != target){
            if(temp.get(i)[1] + temp.get(j)[1] > target)
                j--;
            else
                i++;
        }
        if(temp.get(i)[1] + temp.get(j)[1] == target)
            return temp.get(i)[0] < temp.get(j)[0] ?
                    new int[]{temp.get(i)[0], temp.get(j)[0]} :
                    new int[]{temp.get(j)[0], temp.get(i)[0]};
        else
            return new int[]{};
    }

    public static void main(String[] args) {
        int[] x = new int[]{2, 7, 11, 15};
        int target = 9;
        Two_Sum_1 solution = new Two_Sum_1();
        System.out.println(Arrays.toString(solution.twoSum2(x, target)));
    }
}
