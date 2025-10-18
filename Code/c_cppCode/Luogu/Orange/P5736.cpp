#include <iostream>
using namespace std;

const int MAX_N = 100010;

int n;
int arr[MAX_N];
int cnt;

bool isPrime(int a) {
    if (a < 2)
        return false;
    if (a == 2)
        return true;
    for (int i = 2; i * i <= a; i++) {
        if (a % i == 0)
            return false;
    }
    return true;
}

int main() {
    cin >> n;
    while (n--) {
        int temp;
        cin >> temp;
        if (isPrime(temp)) {
            arr[cnt++] = temp;
        }
    }
    for (int i = 0; i < cnt; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}