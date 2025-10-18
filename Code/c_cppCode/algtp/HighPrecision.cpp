#include <cstring>
#include <iostream>
using namespace std;

const int MAX_D = 4000;

int aArr[MAX_D], bArr[MAX_D], resArr[MAX_D];
string res;

void initialArr() {
    // memset size is in BYTES, use sizeof to clear full arrays
    memset(aArr, 0, sizeof(aArr));
    memset(bArr, 0, sizeof(bArr));
    memset(resArr, 0, sizeof(resArr));
}

void getabArr(string a, string b) {
    int lena = a.size();
    int lenb = b.size();
    for (int i = 0; i < lena; i++) {
        aArr[i] = a[lena - 1 - i] - '0'; //* Remember to + '0'
    }
    for (int i = 0; i < lenb; i++) {
        bArr[i] = b[lenb - 1 - i] - '0';
    }
}

string getRes() {
    int idx;
    // Scan the full result buffer (important for multiplication)
    for (idx = MAX_D - 1; idx > 0 /* keep 0 for all-zero result */; idx--) {
        if (resArr[idx] != 0)
            break;
    }
    do {
        res += char(resArr[idx--] + '0');
    } while (idx >= 0);
    return res;
}

string hiAdd(string a, string b) {
    res = "";
    initialArr(); // Avoid dirt data
    getabArr(a, b);
    for (int i = 0; i < MAX_D - 1 /*Avoid i + 1 overflow*/; i++) {
        resArr[i] += aArr[i] + bArr[i]; // Use += to add carry.
        if (resArr[i] >= 10) {
            resArr[i + 1] = resArr[i] / 10;
            resArr[i] %= 10;
        }
    }
    return getRes();
}

string hiSub(string a, string b) {
    res = "";
    bool isSwap = false;
    initialArr(); // Avoid dirt data
    if (a.size() <= b.size()) {
        if (a < b) {
            swap(a, b); // Make sure a > b
            isSwap = true;
        }
    }
    getabArr(a, b);
    for (int i = 0; i < MAX_D - 1 /*Avoid i + 1 overflow*/; i++) {
        resArr[i] += aArr[i] - bArr[i]; // Use += to add carry.
        if (resArr[i] < 0) {
            resArr[i + 1]--;
            resArr[i] += 10;
        }
    }
    return (isSwap ? "-" : "") + getRes();
}

string hiMul(string a, string b) {
    // Quick zero check
    if (a == "0" || b == "0")
        return "0";
    res = "";
    bool isNeg = false;
    initialArr(); // Avoid dirt data
    if (a[0] == '-') {
        a = a.substr(1);
        if (b[0] == '-') {
            b = b.substr(1);
        } else {
            isNeg = true;
        }
    } else if (b[0] == '-') {
        b = b.substr(1);
        isNeg = true;
    }
    getabArr(a, b);
    for (int i = 0; i < MAX_D - 1; i++) {
        for (int j = 0; j <= i; j++) {
            resArr[i] += aArr[j] * bArr[i - j]; //* Essential step
        }
        if (resArr[i] >= 10) {
            resArr[i + 1] = resArr[i] / 10;
            resArr[i] %= 10;
        }
    }
    return (isNeg ? "-" : "") + getRes();
}

int main() {
    string a, b;
    cin >> a >> b;
    // cout << hiAdd(a, b) << endl;
    // cout << hiSub(a, b) << endl;
    cout << hiMul(a, b) << endl;
}