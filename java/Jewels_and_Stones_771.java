
public class Jewels_and_Stones_771 {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        for(int i = 0 ; i< J.length();i++)
            for(int j= 0;j< S.length();j++)
                if(J.charAt(i) == S.charAt(j))
                    ans += 1;
        return ans;
    }
    public static void main(String args[]){
        assert new Jewels_and_Stones_771().numJewelsInStones("aA", "aAAbbbb") == 3;
        assert new Jewels_and_Stones_771().numJewelsInStones("z", "ZZ") == 0;
    }
}
