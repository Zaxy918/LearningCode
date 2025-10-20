#include <cstring>
#include <iostream>
using namespace std;

const int MAX_D = 10000;
const int MAX_P = 150;

int n, cntPart, resCnt;
string res;
int parts[MAX_P], resParts[MAX_P];
int aArr[MAX_D], resArr[MAX_D];
string resMul;

string hiMul(string a, int b) {
    resMul = "";
    memset(aArr, 0, sizeof(aArr));
    memset(resArr, 0, sizeof(resArr));
    int lena = a.length();
    for (int i = 0; i < lena; i++) {
        aArr[i] = a[lena - 1 - i] - '0';
    }
    for (int i = 0; i < lena * 2; i++) {
        resArr[i] += aArr[i] * b;
        if (resArr[i] >= 10) {
            resArr[i + 1] = resArr[i] / 10;
            resArr[i] %= 10;
        }
    }
    int idx;
    for (idx = lena * 2; idx > 0; idx--) {
        if (resArr[idx] != 0) {
            break;
        }
    }
    do {
        resMul += resArr[idx--] + '0';
    } while (idx >= 0);
    return resMul;
}

void dfs(int cur, int curSum, int cntPart) {
    if (curSum == n) {
        string mul = "1";
        for (int i = 0; i < cntPart; i++) {
            mul = hiMul(mul, parts[i]);
        }
        if (mul.length() > res.length()) {
            res = mul;
        } else if (mul.length() == res.length()) {
            res = mul > res ? mul : res;
        }
        if (res == mul) {
            resCnt = cntPart;
            for (int i = 0; i < cntPart; i++) {
                resParts[i] = parts[i];
            }
        }
        return;
    }
    for (int i = cur + 1; i < n; i++) {
        parts[cntPart] = i;
        if (curSum + i <= n) {
            dfs(i, curSum + i, cntPart + 1);
        } else
            break;
    }
}

int main() {
    cin >> n;
    res = to_string(n);
    resParts[0] = n;
    resCnt = 1;
    dfs(0, 0, 0);
    for (int i = 0; i < resCnt; i++) {
        cout << resParts[i] << (i == resCnt - 1 ? "\n" : " ");
    }
    cout << res;
    return 0;
}