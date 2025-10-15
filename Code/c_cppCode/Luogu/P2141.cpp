#include <iostream>
using namespace std;

const int MAX = 100;

int n;
int cnt;
int nums[MAX];
bool isCnted[MAX];

int main() {
    ios::sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        nums[i] = temp;
    }
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int sum = nums[i] + nums[j];
            for (int k = 0; k < n; k++) {
                if (sum == nums[k] && !isCnted[k]) {
                    cnt++;
                    isCnted[k] = true;
                }
            }
        }
    }
    cout << cnt;
    return 0;
}