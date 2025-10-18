#include <cmath>
#include <iostream>
#include <string>
using namespace std;

const int MAX_N = 30;

int s[MAX_N];
int cnt;
long long sum;
long long totalAdd;

int main() {
    string input;
    int temp;
    while (cin >> temp) {
        s[cnt++] = temp;
        sum += temp;
    }
    totalAdd = 1 << (cnt - 1);
    cout << sum * totalAdd;
    return 0;
}