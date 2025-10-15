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
bool isPalindrome(int n) {
    int reverse = 0;
    int origin = n;
    while (n != 0) {
        reverse = reverse * 10 + n % 10;
        n /= 10;
    }
    return reverse == origin;
}
int main() {
    int a, b;
    cin >> a >> b;
    for (int i = a % 2 == 0 ? a + 1 : a; i <= b; i += 2) {
        if (isPalindrome(i) && isPrime(i))
            cout << i << endl;
    }
}