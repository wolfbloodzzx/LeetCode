

public class Power_of_Two_231 {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        while (n % 2 == 0)
            n /= 2;
        if (n == 1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Power_of_Two_231 solution = new Power_of_Two_231();
        System.out.println(solution.isPowerOfTwo(2));
        System.out.println(solution.isPowerOfTwo(1));
        System.out.println(solution.isPowerOfTwo(16));
        System.out.println(solution.isPowerOfTwo(21));
    }
}
