#include <iostream>
#include <sstream>
#include <gtest/gtest.h>
using namespace std;

template <class A>
void print_vector(vector<A> vec){
    cout << "[ ";
    for (auto iter = vec.begin(); iter != vec.end(); iter++)
        cout << *iter << " ";
    cout << "]" << endl;
}

template <class A>
void print_matrix(vector<vector<A>> mat){
    int rows = mat.size();
    if (rows == 0) return;
    int cols = mat[0].size();
    for (int i = 0; i< rows; i++){
        for (int j = 0; j < cols; j++){
            cout << mat[i][j] << " ";
        }
        cout << endl;
    }
}
