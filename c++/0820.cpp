#include <vector>
#include <iostream>
using namespace std;

class TrieNode {
public:
    vector<TrieNode*> childs;
    char val;
    int path_len = 0;

public:
    TrieNode* find_child(char val){
        for (auto child = childs.begin(); child != childs.end(); child ++)
            if ((*child) -> val == val){
                return *child;
            }
        return nullptr;
    }

    void clear(){
        for (auto iter = childs.begin(); iter != childs.end(); iter++){
            (*iter)->clear();
            delete *iter;
        }
        childs.clear();
    }
};

class Solution {
public:

    int minimumLengthEncoding(vector<string>& words) {
        root = new TrieNode;
        maybe_leaf.clear();
        for (auto str = words.begin(); str != words.end(); str ++){
            insert_string(*str);
        }
        int total_char = 0;
        for (int i = 0; i < maybe_leaf.size(); i++){
            if (maybe_leaf[i]->childs.size() == 0){
                total_char += (maybe_leaf[i]->path_len + 1);
            }
        }
        root->clear();
        delete root;
        return total_char;
    }
private:
    TrieNode * root;
    vector<TrieNode*> maybe_leaf;

    void insert_string(string &str){
        auto child = root;
        for (int i = str.length() - 1; i >= 0; i--){
            char val = str.c_str()[i];
            auto temp = child->find_child(val);
            if (temp != nullptr)
                child = temp;
            else{
                TrieNode* new_child = new TrieNode;
                new_child->val = val;
                child->childs.push_back(new_child);
                if (i == 0){
                    new_child->path_len = str.length();
                    maybe_leaf.push_back(new_child);
                }
                child = new_child;
            }
        }
    }
};

int main(){
    vector<string> input = {"time", "atime", "btime"};
    Solution s;
    cout << s.minimumLengthEncoding(input) << endl;
    return 0;
}