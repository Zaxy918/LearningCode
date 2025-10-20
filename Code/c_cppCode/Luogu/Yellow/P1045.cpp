#include <cmath>
#include <cstring>
#include <iostream>
using namespace std;

const int MAX_D = 1002;
const int DIGITS = 500;

int P;
int aArr[MAX_D], bArr[MAX_D], resArr[MAX_D];
string res, resNum;

void clearData() {
    res = "";
    memset(aArr, 0, sizeof(aArr));
    memset(bArr, 0, sizeof(bArr));
    memset(resArr, 0, sizeof(resArr));
}

void getaArr(string a) {
    for (int i = 0; i < a.length(); i++) {
        aArr[i] = a[a.length() - 1 - i] - '0';
    }
}

void getbArr(string b) {
    for (int i = 0; i < b.length(); i++) {
        bArr[i] = b[b.length() - 1 - i] - '0';
    }
}

string getRes() {
    int idx;
    for (idx = DIGITS - 1; idx > 0; idx--) {
        if (resArr[idx] != 0) {
            break;
        }
    }
    do {
        res += resArr[idx--] + '0';
    } while (idx >= 0);
    return res;
}

string hiMul(string a, string b) {
    clearData();
    getaArr(a);
    getbArr(b);
    for (int i = 0; i < DIGITS; i++) {
        for (int j = 0; j <= i; j++) {
            resArr[i] += aArr[j] * bArr[i - j];
        }
        if (resArr[i] >= 10) {
            resArr[i + 1] = resArr[i] / 10;
            resArr[i] %= 10;
        }
    }
    return getRes();
}

void powTwo() {
    resNum = "1";
    string temp = "2";
    while (P) {
        if (P & 1) {
            resNum = hiMul(resNum, temp);
        }
        temp = hiMul(temp, temp);
        P >>= 1;
    }
}

int main() {
    cin >> P;
    cout << (int)(log10(2) * P) + 1 << endl;
    powTwo();
    resNum[resNum.length() - 1] -= 1;
    for (int i = 0; i < DIGITS; i++) {
        if (i % 50 == 0 && i != 0) {
            cout << endl;
        }
        if (DIGITS - i > resNum.length()) {
            cout << 0;
        } else {
            cout << resNum[resNum.length() - DIGITS + i];
        }
    }
    return 0;
}