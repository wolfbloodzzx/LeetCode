#include <vector>
#include <unordered_map>
#include "utils.h"

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        unordered_map<int, int> map;
        for (int i = 0; i < nums.size(); i++)
            map[nums[i]] = i;
        for (int i = 0; i < nums.size(); i++){
            int other = target - (nums[i]);
            if (map.count(other) != 0 && map[other] != -1){
                if(map[other] != i){
                    result.push_back(i);
                    result.push_back(map[other]);
                    break;
                }
            }
        }
        return result;
    }
};

int main()
{
    Solution s;
    vector<int> nums = {2, 7, 11, 15};
    int target = 9;
    vector<int> result = s.twoSum(nums, target);
    print_vector<int>(result);
    return 0;
}