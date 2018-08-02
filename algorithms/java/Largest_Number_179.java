

import java.util.*;

public class Largest_Number_179 {
    /**
     * 排序，但是排序条件很有意思，两个数a和b，比较条件是
     * 比较a+b和b+a，哪个大哪个在前边
     * 注意判断数值全部为0的情况
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        List<String> tmp = new ArrayList<>();
        for(int i : nums)
            tmp.add(i + "");
        Collections.sort(tmp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1+o2).compareTo(o2+o1);
            }
        });
        String result = "";
        for(String i : tmp) {
            if(Integer.parseInt(i) == 0 && result.equals(""))
                continue;
            result += i;
        }
        return result.equals("") ? "0" : result;
    }
    public static void main(String[] args){
        int[] nums = new int[]{3,30,34,5,9};
        Largest_Number_179 solution = new Largest_Number_179();
        System.out.println(solution.largestNumber(nums));
    }
}
