#include <iostream>
using namespace std;

const int MAX_N = 201;
const int WIN_ARR[5][5] = {
    {0, -1, 1, 1, -1},
    {1, 0, -1, 1, -1},
    {-1, 1, 0, -1, 1},
    {-1, -1, 1, 0, 1},
    {1, 1, -1, -1, 0}};

int N, Na, Nb;
int aScr, bScr;
int aArr[MAX_N], bArr[MAX_N];

int main() {
    cin >> N >> Na >> Nb;
    for (int i = 0; i < Na; i++) {
        cin >> aArr[i];
    }
    for (int i = 0; i < Nb; i++) {
        cin >> bArr[i];
    }
    for (int i = 0; i < N; i++) {
        int optA = aArr[i % Na];
        int optB = bArr[i % Nb];
        int winRes = WIN_ARR[optA][optB];
        if (winRes == 1) {
            aScr++;
        } else if (winRes == -1) {
            bScr++;
        }
    }
    cout << aScr << " " << bScr << endl;
    return 0;
}