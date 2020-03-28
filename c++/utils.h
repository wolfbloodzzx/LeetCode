#include <iostream>
#include <sstream>
using namespace std;

template <class A>
void print_vector(vector<A> vec){
    cout << "[ ";
    for (auto iter = vec.begin(); iter != vec.end(); iter++)
        cout << *iter << " ";
    cout << "]" << endl;
}
