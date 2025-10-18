#include <cstring>
#include <iostream>
using namespace std;

const int MAX_D = 10002;

int t, n, a;
int cnt;
int aArr[MAX_D], resArr[MAX_D];
string res;

void clearArr() {
    memset(aArr, 0, sizeof(aArr));
    memset(resArr, 0, sizeof(resArr));
}

void getaArr(string a) {
    for (int i = 0; i < a.length(); i++) {
        aArr[i] = a[a.length() - 1 - i] - '0';
    }
}

string getRes(int len) {
    int idx;
    for (idx = len; idx > 0; idx--) {
        if (resArr[idx] != 0) {
            break;
        }
    }
    for (int i = idx; i >= 0; i--) {
        res += resArr[i] + '0';
    }
    return res;
}

string hiMul(string a, int b) {
    res = "";
    clearArr();
    getaArr(a);
    int lena = a.length();
    for (int i = 0; i < lena * 2 + 1; i++) {
        resArr[i] += aArr[i] * b;
        if (resArr[i] >= 10) {
            resArr[i + 1] = resArr[i] / 10;
            resArr[i] %= 10;
        }
    }
    return getRes(lena * 2 + 1);
}

string hiStep(int n) {
    if (n == 0)
        return "1";
    return hiMul(hiStep(n - 1), n);
}

int main() {
    cin >> t;
    while (t--) {
        cnt = 0;
        cin >> n >> a;
        res = hiStep(n);
        for (int i = 0; i < res.length(); i++) {
            if (res[i] == a + '0')
                cnt++;
        }
        cout << cnt << endl;
    }
    return 0;
}