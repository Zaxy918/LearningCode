#include <iostream>
using namespace std;

string s;

string reverseNum(string str) {
    if (str == "0") // Special case
        return "0";
    bool flag = false;
    string res;
    for (int i = str.size() - 1; i >= 0; i--) {
        if (str[i] == '0' && flag == false)
            continue;
        flag = true;
        res += str[i];
    }
    return res;
}

string reverseRight(string str) {
    if (str == "0")
        return "0";
    string res;
    size_t start = 0;
    for (int i = 0; i < str.size(); i++) {
        if (str[i] != '0') {
            start = i;
            break;
        }
    }
    str = str.substr(start);
    for (int i = str.size() - 1; i >= 0; i--) {
        res += str[i];
    }
    return res;
}

int main() {
    cin >> s;
    int idx;
    if ((idx = s.find('.')) != string::npos) {
        string left = s.substr(0, idx);
        string right = s.substr(idx + 1);
        left = reverseNum(left);
        right = reverseRight(right);
        cout << left + "." + right << endl;
    } else if ((idx = s.find('/')) != string::npos) {
        string left = s.substr(0, idx);
        string right = s.substr(idx + 1);
        left = reverseNum(left);
        right = reverseNum(right);
        cout << left + "/" + right << endl;
    } else if (s[s.size() - 1] == '%') {
        string num = s.substr(0, s.size() - 1);
        num = reverseNum(num);
        cout << num + "%" << endl;
    } else {
        s = reverseNum(s);
        cout << s << endl;
    }
}