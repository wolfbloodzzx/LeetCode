/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 */

// @lc code=start

#include <unordered_map>
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int> tmp_map;
        for (int i = 0; i < nums.size(); i++) {
            tmp_map.insert(std::make_pair(nums[i], i));
        }
        std::vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            int value = target - nums[i];
            auto find_iter = tmp_map.find(value);
            if (find_iter != tmp_map.end() && i != find_iter->second) {
                result.push_back(i);
                result.push_back(find_iter->second);
                break;
            }
        }
        return result;
    }
};
// @lc code=end

