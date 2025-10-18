#include <iostream>
using namespace std;

const int MAX_N = 2001;

string n1, n2;
int n1Arr[MAX_N];
int n2Arr[MAX_N];
int resArr[MAX_N * 2];
string res;

string hiMult(string n1, string n2) {
    if (n1 == "0" || n2 == "0")
        return "0";
    int len1 = n1.size();
    int len2 = n2.size();
    for (int i = len1 - 1; i >= 0; i--) {
        n1Arr[len1 - 1 - i] = n1[i] - '0';
    }
    for (int i = len2 - 1; i >= 0; i--) {
        n2Arr[len2 - 1 - i] = n2[i] - '0';
    }
    int carry;
    for (int i = 0; i < len1; i++) {
        carry = 0;
        int j;
        for (j = 0; j < len2; j++) {
            int mult = n1Arr[i] * n2Arr[j] + carry + resArr[j + i];
            carry = mult / 10;
            resArr[j + i] = mult % 10;
        }
        resArr[i + j] = carry;
    }
    for (int i = carry ? len1 + len2 - 1 : len1 + len2 - 2; i >= 0; i--) {
        res += resArr[i] + '0';
    }
    return res;
}

int main() {
    cin >> n1 >> n2;
    cout << hiMult(n1, n2);
    return 0;
}