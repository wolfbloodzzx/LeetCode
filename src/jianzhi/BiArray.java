package jianzhi;

/**
 * 二维数组的查找
 */
public class BiArray {
    /**
     * 不是最佳解，思路是从左上查找
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        int i_l = array.length;
        int j_l = array[0].length;
        boolean flag = false;
        int i=0, j=0;
        while(!flag){
            if(i >= i_l || j >= j_l)
                break;
            if(i < 0 || j<0)
                break;
            if(array[i][j] == target){
                flag = true;
                break;
            }else if(array[i][j] < target){
                if(j == j_l -1)
                    i++;
                else
                    j++;
            }else if(array[i][j] > target){
                if(j-1 >=0 && array[i][j-1]<target){
                    j--;
                    i++;
                }else{
                    j--;
                }
            }
        }
        return flag;
    }

    /**
     * 从左下角或者右上角开始检索，这样的话不管当前状态大于还是小于target，都只有一种转移方向
     * @param target
     * @param array
     * @return
     */
    public boolean FindBest(int target, int [][] array) {
        int i_l = array.length;
        int j_l = array[0].length;
        boolean flag = false;
        int i = i_l -1;
        int j = 0;
        while(true){
            if(i<0 || j< 0||i >= i_l||j>=j_l)
                break;
            if(array[i][j] > target){
                i = i-1;
            }else if(array[i][j] < target){
                j = j+1;
            }else{
                flag = true;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args){
        int[][] test = {{1,2,4,6,8,10,11,13,15,17,20,22,24,27,30,32,35,36,38,39,42,44,46,47,48,49,51,54,55,56},
                {3,4,6,8,11,13,15,18,19,20,23,25,27,29,33,36,38,41,42,45,48,50,53,54,57,60,63,65,66,67},
                {5,7,8,11,14,15,17,19,21,23,24,28,31,33,36,39,41,44,47,49,52,53,56,57,60,63,66,68,71,72},
                {7,10,13,14,17,19,22,25,26,27,30,32,34,37,39,42,44,46,50,53,55,56,59,61,64,66,69,72,74,76}};
        System.out.println(new BiArray().Find(5,test));
        System.out.println(new BiArray().Find(10,test));
        System.out.println(new BiArray().Find(-10,test));
        System.out.println(new BiArray().FindBest(5,test));
        System.out.println(new BiArray().FindBest(10,test));
        System.out.println(new BiArray().FindBest(-10,test));
    }
}
