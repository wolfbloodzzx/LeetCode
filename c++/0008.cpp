#include <vector>
#include <unordered_map>
#include <iostream>
#include <cmath>

using namespace std;

class Solution {
public:
    int myAtoi(string str) {
        int flag = 1;
        long value = 0;
        int start = false;
        for (int i = 0; i < str.length(); i++){
            char digit = str.c_str()[i];
            if (!start && (digit == ' ' || digit == '\t')){
                    continue;
            } else if (!start && (digit == '-' || digit == '+')){
                flag = digit == '+' ? 1 : -1;
                start = true;
            } else if (digit >= '0' && digit <= '9') {
                start = true;
                value = value * 10 + (digit - '0');
                if (flag > 0 && value > INT_MAX)
                    return INT_MAX;
                else if (flag < 0 && flag * value < INT_MIN)
                    return INT_MIN;
            } else {
                break;
            }
        }
        return flag * value;
    }
};

int main(){
    Solution s;
    cout << s.myAtoi("   +-42") << endl;
    cout << s.myAtoi("4193 with words") << endl;
    cout << s.myAtoi("words and 987") << endl;
    cout << s.myAtoi("-91283472332") << endl;
    return 0;
}