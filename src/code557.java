import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class code557 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        List l = Arrays.asList(s.split(" "));
        Collections.reverse(l);
        for(int i = 0;i< l.size();i++){
            sb.append(l.get(i));
            if(i == l.size()-1)
                continue;
            else
                sb.append(" ");
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        System.out.println(new code557().reverseWords("Let's take LeetCode contest"));
    }
}
