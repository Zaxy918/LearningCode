#include <iostream>
using namespace std;

long long res;
string pre, post;
int pow;

int main() {
    cin >> pre >> post;
    for (int i = 0; i < pre.length() - 1; i++) {
        for (int j = 0; j < post.length() - 1; j++) {
            if (pre[i] == post[j + 1] && pre[i + 1] == post[j]) pow++;
        }
    }
    cout << (1 << pow);
    return 0;
}