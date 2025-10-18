#include <climits>
#include <iostream>
using namespace std;

int n, m;
double maxScr;

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        double tempSum = 0;
        double tempMinScr = INT_MAX, tempMaxScr = 0;
        for (int j = 0; j < m; j++) {
            double temp;
            cin >> temp;
            tempSum += temp;
            tempMinScr = temp < tempMinScr ? temp : tempMinScr;
            tempMaxScr = temp > tempMaxScr ? temp : tempMaxScr;
        }
        double tempAvg = (tempSum - tempMaxScr - tempMinScr) / (m - 2.0);
        maxScr = tempAvg > maxScr ? tempAvg : maxScr;
    }
    printf("%.2lf", maxScr);
    return 0;
}