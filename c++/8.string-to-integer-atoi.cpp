/*
 * @lc app=leetcode id=8 lang=cpp
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
public:
    int myAtoi(string s) {
        long result = 0;
        int start_flag = false;
        int is_pos = true;
        for (int i = 0; i < s.size(); i++) {
            char c = s[i];
            
            if (!start_flag && !(is_digit(c) || is_zf(c) || c == ' '))
                break;
            if (!start_flag && is_zf(c) && i + 1 < s.size() && !is_digit(s[i+1]))
                break;

            if (start_flag && is_digit(c)) {
                result = result * 10 + (c - '0');
            } else if (start_flag && !is_digit(c)) {
                break;
            } else if (!start_flag && is_zf(c)) {
                if (i == s.size() - 1) continue;
                if (is_digit(s[i+1])) {
                    start_flag = true;
                    if (c == '-') is_pos = false;
                }
            } else if (!start_flag && is_digit(c)) {
                start_flag = true;
                result = c - '0';
            }
            if (result > 2147483647 || result < -2147483648)
                break;
        }
        if (!is_pos)
            result = -result;
        if (result > 2147483647)
            return 2147483647;
        else if (result < -2147483648)
            return -2147483648;
        else
            return result;
    }
private:
    bool is_digit(char c) {
        if (c >= '0' && c <= '9')
            return true;
        else
            return false;
    }
    bool is_zf(char c) {
        if (c == '-' || c == '+')
            return true;
        else
            return false;
    }
};
// @lc code=end

