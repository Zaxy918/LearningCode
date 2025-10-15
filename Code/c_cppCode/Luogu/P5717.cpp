#include <cmath>
#include <iostream>
using namespace std;
bool isTriangle(int a, int b, int c) { return a + b > c && abs(a - b) < c; }
double cosA(int a, int b, int c) { return (a * a + b * b - c * c) / 2 * a * b; }

bool rightA(int a, int b, int c) { return a * a + b * b == c * c; }

bool isRight(int a, int b, int c) {
    return rightA(a, b, c) || rightA(b, c, a) || rightA(c, a, b);
}

bool isAcute(int a, int b, int c) {
    return cosA(a, b, c) > 0 && cosA(b, c, a) > 0 && cosA(c, a, b) > 0;
}

bool isObtuse(int a, int b, int c) {
    return cosA(a, b, c) < 0 || cosA(b, c, a) < 0 || cosA(c, a, b) < 0;
}

bool isIsosceles(int a, int b, int c) { return a == b || a == c || b == c; }

bool isEquilateral(int a, int b, int c) { return a == b && a == c && b == c; }

int main() {
    int a, b, c;
    cin >> a >> b >> c;
    if (!isTriangle(a, b, c)) {
        cout << "Not triangle" << endl;
    } else {
        if (isRight(a, b, c)) {
            cout << "Right triangle" << endl;
        }
        if (isAcute(a, b, c)) {
            cout << "Acute triangle" << endl;
        }
        if (isObtuse(a, b, c)) {
            cout << "Obtuse triangle" << endl;
        }
        if (isIsosceles(a, b, c)) {
            cout << "Isosceles triangle" << endl;
        }
        if (isEquilateral(a, b, c)) {
            cout << "Equilateral triangle" << endl;
        }
    }
}
