#include <iostream>
using namespace std;

int n, l, r;
string str;

void initStr() {
    for (int i = 0; i < n; i++) {
        str += "o";
    }
    l = str.length() - 1;
    for (int i = 0; i < n; i++) {
        str += "*";
    }
    r = str.length();
    str += "--";
}

int main() {
    ios::sync_with_stdio(false);
    cin >> n;
    initStr();
    cout << str << endl;
    while (l) {
        if (r - l > 5) {
            swap(str[l], str[r]);
            swap(str[l + 1], str[r + 1]);
            r -= 2;
            cout << str << endl;
            swap(str[l], str[r]);
            swap(str[l + 1], str[r + 1]);
            l--;
            cout << str << endl;
        } else {
            swap(str[l], str[r]);
            swap(str[l + 1], str[r + 1]);
            r--;
            cout << str << endl;
            swap(str[l], str[r]);
            swap(str[l + 1], str[r + 1]);
            l -= 2;
            cout << str << endl;
            swap(str[l], str[r]);
            swap(str[l + 1], str[r + 1]);
            r--;
            cout << str << endl;
            swap(str[l], str[r]);
            swap(str[l + 1], str[r + 1]);
            l--;
            cout << str << endl;
            swap(str[l], str[r]);
            swap(str[l + 1], str[r + 1]);
            cout << str << endl;
        }
    }
    return 0;
}