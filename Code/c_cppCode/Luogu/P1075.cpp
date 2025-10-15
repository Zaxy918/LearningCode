#include <cmath>
#include <iostream>
using namespace std;
bool isPrime(int n) {
    if (n < 2)
        return false;
    if (n == 2)
        return true;
    for (int i = 2; i <= sqrt(n); i++) {
        if (n % i == 0)
            return false;
    }
    return true;
}
int main() {
    int n;
    cin >> n;
    for (int i = 2; i <= sqrt(n); i++) {
        if (isPrime(i) && n % i == 0) {
            cout << n / i << endl;
            break;
        }
    }
    return 0;
}