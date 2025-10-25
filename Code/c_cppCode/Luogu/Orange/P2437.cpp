#include <cstring>
#include <iostream>
using namespace std;

const int MAX_N = 1001;
const int MAX_D = 4001;

int m, n;
string dp[MAX_N];
int aArr[MAX_D], bArr[MAX_D], resArr[MAX_D];
string res;

string hiAdd(string a, string b) {
    res = "";
    memset(aArr, 0, sizeof(aArr));
    memset(bArr, 0, sizeof(bArr));
    memset(resArr, 0, sizeof(resArr));
    for (int i = 0; i < a.length(); i++) {
        aArr[i] = a[a.length() - 1 - i] - '0';
    }
    for (int i = 0; i < b.length(); i++) {
        bArr[i] = b[b.length() - 1 - i] - '0';
    }
    for (int i = 0; i < MAX_D - 1; i++) {
        resArr[i] += aArr[i] + bArr[i];
        if (resArr[i] >= 10) {
            resArr[i + 1] = resArr[i] / 10;
            resArr[i] %= 10;
        }
    }
    int idx;
    for (idx = MAX_D - 1; idx > 0; idx--) {
        if (resArr[idx] != 0) break;
    }
    do {
        res += resArr[idx] + '0';
    } while (idx--);
    return res;
}

int main() {
    cin >> m >> n;
    dp[0] = dp[1] = "1";
    for (int i = 2; i <= n - m; i++) {
        dp[i] = hiAdd(dp[i - 1], dp[i - 2]);
    }
    cout << dp[n - m];
    return 0;
}