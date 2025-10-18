#include <cstring>
#include <iostream>
using namespace std;

const int MAX_D = 2000;

int n;
int aArr[MAX_D];
int bArr[MAX_D];
int resArr[MAX_D];
string res;

void clearArr() {
    memset(aArr, 0, sizeof(aArr));
    memset(bArr, 0, sizeof(bArr));
    memset(resArr, 0, sizeof(resArr));
}

void getabArr(string a, string b) {
    int lena = a.size();
    int lenb = b.size();
    for (int i = 0; i < lena; i++) {
        aArr[i] = a[lena - 1 - i] - '0';
    }
    for (int i = 0; i < lenb; i++) {
        bArr[i] = b[lenb - 1 - i] - '0';
    }
}

string getRes() {
    int idx;
    for (idx = MAX_D - 1; idx > 0; idx--) {
        if (resArr[idx] != 0) {
            break;
        }
    }
    do {
        res += resArr[idx--] + '0';
    } while (idx >= 0);
    return res;
}

string hiAdd(string a, string b) {
    res = "";
    clearArr();
    getabArr(a, b);
    for (int i = 0; i < MAX_D - 1; i++) {
        resArr[i] += aArr[i] + bArr[i];
        if (resArr[i] >= 10) {
            resArr[i + 1] = resArr[i] / 10;
            resArr[i] %= 10;
        }
    }
    return getRes();
}

string hiMul(string a, string b) {
    res = "";
    clearArr();
    getabArr(a, b);
    for (int i = 0; i < MAX_D - 1; i++) {
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

string stepAdd(int x) {
    if (x == 1)
        return "1";
    string mul = "1";
    for (int i = 1; i <= x; i++) {
        string j = to_string(i);
        mul = hiMul(mul, j);
    }
    return hiAdd(mul, stepAdd(x - 1));
}

int main() {
    cin >> n;
    cout << stepAdd(n);
    return 0;
}