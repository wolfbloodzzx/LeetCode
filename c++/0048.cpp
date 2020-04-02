#include <iostream>
#include <vector>
#include "utils.h"
using namespace std;

class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int rows = matrix.size();
        if (rows == 0)
            return;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < rows / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][rows - j - 1];
                matrix[i][rows-j-1] = temp;
            }
    }
};

int main() 
{
    Solution s;
    vector<vector<int>> mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    print_matrix(mat);
    cout << endl;
    s.rotate(mat);
    print_matrix(mat);
    return 0;
}