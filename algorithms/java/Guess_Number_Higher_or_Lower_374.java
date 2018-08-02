public class Guess_Number_Higher_or_Lower_374 {
    public int guessNumber(int n) {
        int s = 0, e = n;
        int t = n / 2;
        while (guess(t) != 0) {
            if (guess(t) == -1)
                s = t;
            else if (guess(t) == 1)
                e = t;
            t = (s+e)/2;
            if(e == s)
                break;
        }
        return t;
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
