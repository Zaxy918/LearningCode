#include <algorithm>
#include <iostream>
using namespace std;

const int NUM_STICKS[10] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

int n;
int cnt;
int stks[8888];

int getSticks(int num) {
    int stks = 0;
    string numStr = to_string(num);
    for_each(numStr.begin(), numStr.end(), [&stks](char c) { stks += NUM_STICKS[c - '0']; });
    return stks;
}

int main() {
    cin >> n;
    for (int i = 0; i <= 4000; i++) {
        stks[i] = getSticks(i);
    }
    for (int i = 0; i < 2000; i++) {
        for (int j = 0; j < 2000; j++) {
            if (stks[i] + stks[j] + stks[i + j] == n - 4) cnt++;
        }
    }
    cout << cnt;
    return 0;
}