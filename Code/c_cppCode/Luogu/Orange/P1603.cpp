#include <algorithm>
#include <iostream>
#include <map>
#include <string>
#include <vector>
using namespace std;

vector<string> nums;
const map<string, int> NUMBERS = {
    {"one", 1}, {"two", 2}, {"three", 3}, {"four", 4}, {"five", 5}, {"six", 6}, {"seven", 7}, {"eight", 8}, {"nine", 9}, {"ten", 10}, {"eleven", 11}, {"twelve", 12}, {"thirteen", 13}, {"fourteen", 14}, {"fifteen", 15}, {"sixteen", 16}, {"seventeen", 17}, {"eighteen", 18}, {"nineteen", 19}, {"twenty", 20}, {"a", 1}, {"both", 2}, {"another", 1}, {"first", 1}, {"second", 2}, {"third", 3}};

int main() {
    string word;
    while (cin >> word && word != ".") {
        if (NUMBERS.count(word)) {
            string num = to_string((NUMBERS.at(word) * NUMBERS.at(word)) % 100);
            if (num.size() == 1)
                num = "0" + num;
            nums.push_back(num);
        }
    }
    if (nums.size() == 0)
        cout << 0 << endl;
    else {
        sort(nums.begin(), nums.end());
        string res;
        for (string num : nums) {
            res += num;
        }
        for (int i = 0; i < res.size(); i++) {
            if (res[i] != '0') {
                res = res.substr(i);
                if (res.size() != 0)
                    cout << res << endl;
                else
                    cout << "0" << endl;
                break;
            }
        }
    }
    return 0;
}