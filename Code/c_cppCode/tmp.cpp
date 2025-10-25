#include <algorithm>
#include <cmath>
#include <cstdio>
#include <iostream>

#define N 110
using namespace std;

int n, m, a[N], f[N][10010];

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; i++)
        scanf("%d", &a[i]);
    for (int i = 0; i <= n; i++) // 注意这里要从0开始
        f[i][0] = 1;
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++) {
            f[i][j] += f[i - 1][j];
            if (j >= a[i])
                f[i][j] += f[i - 1][j - a[i]];
        }
    cout << f[n][m];
    return 0;
}
