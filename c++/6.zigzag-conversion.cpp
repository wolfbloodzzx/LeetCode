/*
 * @lc app=leetcode id=6 lang=cpp
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
#include <algorithm>
#include <unordered_map>
#include <vector>
#include <sstream>

class Solution
{
public:
    string convert(string s, int numRows)
    {
        if (numRows == 1)
            return s;
        std::vector<std::pair<char, std::pair<int, int> > > points;
        int per_loop_col = 1 + numRows - 2;
        int per_loop_nums = 2 * numRows - 2;
        std::cout << per_loop_col << " " << per_loop_nums << std::endl;
        stringstream ss;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s[i];
            int x, y;
            int tmp = i % per_loop_nums;
            printf("%d ", i % per_loop_nums);
            if (tmp < numRows)
            {
                x = tmp;
                y = per_loop_col * (i / per_loop_nums);
            }
            else
            {
                x = 2 * numRows - tmp -2;
                y = per_loop_col * (i / per_loop_nums) + tmp - numRows + 1;
            }
            points.push_back(std::make_pair(c, std::make_pair(x, y)));
            std::cout << x << " " << y << std::endl;
        }
        sort(points.begin(), points.end(), Solution::cmp);
        for (auto iter = points.begin(); iter != points.end(); iter++) {
            ss << iter->first;
        }
        return ss.str();
    }

private:
    static bool cmp(const std::pair<char, std::pair<int, int> > &o1,
             const std::pair<char, std::pair<int, int> > &o2)
    {
        auto p1 = o1.second;
        auto p2 = o2.second;
        if (p1.first < p2.first) {
            return true;
        } else if (p1.first == p2.first) {
            if (p1.second < p2.second)
                return true;
            else
                return false;
        } else
            return false;
    }
};
// @lc code=end
