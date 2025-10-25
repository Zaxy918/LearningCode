#include <cctype>
#include <iostream>
using namespace std;

string zip;

string dfs(string cur) {
    int times = 0;
    int idx = 0;
    while (isdigit(cur[idx])) {
        times = times * 10 + cur[idx++] - '0';
    }
    times = times == 0 ? 1 : times;
    for (int i = 0; i < cur.length(); i++) {
        if (cur[i] == '[') {
            int cnt = 1;
            int j = i + 1;
            while (cnt) {
                if (cur[j] == '[') cnt++;
                if (cur[j] == ']') cnt--;
                j++;
            }
            string pre = cur.substr(0, i);
            string tail = cur.substr(j);
            string mid = dfs(cur.substr(i + 1, j - 2 - i));
            cur = pre + mid + tail;
        }
    }
    string tmp = cur.substr(idx);
    string res;
    for (int i = 0; i < times; i++) {
        res += tmp;
    }
    return res;
}

int main() {
    cin >> zip;
    cout << dfs(zip);
    return 0;
}