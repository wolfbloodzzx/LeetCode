
import java.util.Arrays;

public class Rotate_Image_48 {
    /**
     * 思路就是尽量将旋转转化为交换
     * 两次交换
     * 第一次对角交换
     * 第二次左右交换
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // swap
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        // swap2
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
    }

    public void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++)
            System.out.println(Arrays.toString(m[i]));
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        Rotate_Image_48 solution = new Rotate_Image_48();
        solution.printMatrix(matrix);
        solution.rotate(matrix);
        solution.printMatrix(matrix);
    }
}
