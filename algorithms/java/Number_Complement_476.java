

public class Number_Complement_476 {
    public int findComplement(int num) {

        int bit = num, result =0;
        int ans = 0;
        while(bit != 0){
            result += Math.abs(bit % 2 - 1) * Math.pow(2, ans);
            bit = bit / 2;
            ans += 1;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(new Number_Complement_476().findComplement(5));
    }
}
