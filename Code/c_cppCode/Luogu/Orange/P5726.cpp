#include <climits>
#include <iostream>
using namespace std;
int main() {
    int n;
    cin >> n;
    double sum = 0.0;
    int maxVal = 0;
    int minVal = INT_MAX;
    for (int i = 0; i < n; i++) {
        int score;
        cin >> score;
        sum += score;
        minVal = score < minVal ? score : minVal;
        maxVal = score > maxVal ? score : maxVal;
    }
    sum = sum - minVal - maxVal;
    printf("%.2lf", sum / (n - 2));
}