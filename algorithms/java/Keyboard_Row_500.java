
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keyboard_Row_500 {
    public String[] findWords(String[] words) {
        String[] rows = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        List<String> result = new ArrayList<>();
        for(String tw : words){
            String w = tw.toUpperCase();
            int row = -1;
            boolean b = true;
            for(int i = 0 ; i< rows.length;i++){
                if(rows[i].contains(w.charAt(0) + ""))
                    row = i;
            }
            for(char c : w.toCharArray()){
                if(rows[row].contains(c + ""))
                    continue;
                else{
                    b = false;
                    break;
                }
            }
            if(b){
                result.add(tw);
            }
        }
        return result.toArray(new String[result.size()]);
    }
    public static void main(String[] args){
        String[] test = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(new Keyboard_Row_500().findWords(test)));
    }
}
