import java.util.ArrayList;
import java.util.List;

public class Code728 {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.selfDividingNumbers(1,22));
//        System.out.println(s.isDivNum(21));
    }

}
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i = left ;i<=right;i++){
            if(isDivNum(i)){
                result.add(i);
            }
        }
        return result;
    }
    public boolean isDivNum(int num){
        int temp = num;
        if(temp == 0){
            return false;
        }
        while(temp != 0){
            int d = temp % 10;
            temp = temp /10;
            if(d == 0 || num % d != 0){
                return false;
            }
        }
        return true;
    }
}