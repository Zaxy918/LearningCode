#include <iostream>
using namespace std;

const int MAX_N = 10000;

int N, cnt;
int carr[MAX_N];

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> carr[i];
    }
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
            if (carr[j] < carr[i]) {
                cnt++;
            }
        }
    }
    cout << cnt;
    return 0;
}