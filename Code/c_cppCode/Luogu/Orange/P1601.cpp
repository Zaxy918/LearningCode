#include <iostream>
using namespace std;

string n1;
string n2;

string hiAdd(string a, string b) {
    int carry = 0;
    string res;
    int n1arr[501];
    int len1 = 0;
    int n2arr[501];
    int len2 = 0;
    for (int i = a.size() - 1; i >= 0; i--) {
        n1arr[len1++] = a[i] - '0';
    }
    for (int i = b.size() - 1; i >= 0; i--) {
        n2arr[len2++] = b[i] - '0';
    }
    int len = max(len1, len2);
    int resArr[502];
    int lenRes = 0;
    for (int i = 0; i < len; i++) {
        int sum = (i < len1 ? n1arr[i] : 0) + (i < len2 ? n2arr[i] : 0) + carry;
        resArr[lenRes++] = sum % 10;
        carry = sum >= 10 ? 1 : 0;
    }
    if (carry == 1)
        resArr[lenRes++] = carry;
    for (int i = lenRes - 1; i >= 0; i--) {
        res += resArr[i] + '0';
    }
    return res;
}

int main() {
    cin >> n1 >> n2;
    cout << hiAdd(n1, n2) << endl;
    return 0;
}