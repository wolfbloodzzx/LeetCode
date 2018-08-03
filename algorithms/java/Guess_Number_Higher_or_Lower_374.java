public class Guess_Number_Higher_or_Lower_374 {
    /**
     * 二分查找
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        for (int start = 1, end = n;;) {
            int mid = start + ((end - start) >> 1);
            switch(guess(mid)) {
                case -1: end = mid; break;
                case  0: return mid;
                case +1: start = mid + 1; break;
            }
        }
    }

    public int guess(int num) {
        if (num > 6)
            return 1;
        else if (num < 6)
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Guess_Number_Higher_or_Lower_374().guessNumber(10));
    }
}
