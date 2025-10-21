#include <algorithm>
#include <iostream>
using namespace std;

const int NUM_STICKS[10] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

int n;
int abc[3];
int cnt;

int getSticks(int num) {
    int stks = 0;
    string numStr = to_string(num);
    for_each(numStr.begin(), numStr.end(), [&stks](char c) { stks += NUM_STICKS[c - '0']; });
    return stks;
}

void dfs(int d, int sticks) {
    if (d == 3) {
        if (sticks == n && abc[0] + abc[1] == abc[2]) cnt++;
    }
    int num = 0;
}
int main() {
    cin >> n;
    return 0;
}