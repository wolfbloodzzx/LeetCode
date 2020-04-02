#include <iostream>
using namespace std;

class Solution {
public:
    bool isPowerOfTwo(int n) {
        while(n >= 2) {
            if (n % 2 == 1)
                return false;
            n = n >> 1;
        }
        return n == 1;
    }
};

int main()
{
    Solution s;
    cout << s.isPowerOfTwo(0) << endl;
    cout << s.isPowerOfTwo(2) << endl;
    cout << s.isPowerOfTwo(100) << endl;
    cout << s.isPowerOfTwo(1024 * 1024) << endl;
    return 0;
}