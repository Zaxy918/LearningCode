#include <iostream>
using namespace std;
const int MOD = 11;
int main() {
    string ISBN;
    cin >> ISBN;
    int nums[10];
    int cnt = 0;
    for (char c : ISBN) {
        if (c != '-') {
            if (c == 'X')
                nums[cnt++] = 10;
            else
                nums[cnt++] = c - '0';
        }
    }
    int id = 0;
    for (int i = 0; i < 9; i++) {
        id += nums[i] * (i + 1);
    }
    id %= MOD;
    if (id == nums[9])
        cout << "Right";
    else {
        ISBN[12] = id == 10 ? 'X' : id + '0';
        cout << ISBN;
    }
    return 0;
}