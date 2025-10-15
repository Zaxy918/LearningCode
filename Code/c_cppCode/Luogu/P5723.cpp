#include <cmath>
#include <iostream>
using namespace std;
bool isPrime(int n) {
    if (n == 2)
        return true;
    for (int i = 2; i <= sqrt(n); i++) {
        if (n % i == 0)
            return false;
    }
    return true;
}
int main() {
    int L;
    cin >> L;
    int sum = 0;
    int cnt = 0;
    for (int i = 2; sum + i <= L; i++) {
        if (isPrime(i)) {
            cout << i << endl;
            sum += i;
            cnt++;
        }
    }
    cout << cnt << endl;
    return 0;
}
