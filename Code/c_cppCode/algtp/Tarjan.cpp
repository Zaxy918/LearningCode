#include <iostream>
using namespace std;

const int MAX_N = 1e5 + 1;
const int MAX_M = 1e5 + 1;

int head[MAX_N], nexte[MAX_M], to[MAX_M], cnt;
int dfn[MAX_N], low[MAX_N], bel[MAX_N], sccSize[MAX_N], sccCnt, tot;
int stack[MAX_N];
int top;
bool ins[MAX_N];

void TarjanSCC(int u) {
    dfn[u] = low[u] = ++tot;
    ins[stack[++top] = u] = true;
    for (int i = head[u], v; i > 0; i = nexte[i]) {
        v = to[i];
        if (!dfn[v]) { // Havem't been visited, i is a forward edge.
            TarjanSCC(v);
            low[u] = min(low[u], low[v]);
        } else if (ins[v]) {              // A backward edge
            low[u] = min(low[u], dfn[v]); // If v is in stack, it can't be the first node of scc.So we can use dfn[v] there.
            // low[u] = min(low[u], low[v]); For this function, this code is also right.
        }
    }
    if (low[u] == dfn[u]) {
        int cur;
        sccCnt++;
        do {
            cur = stack[top--];
            bel[cur] = sccCnt;
            ins[cur] = false;
            sccSize[sccCnt]++;
        } while (cur != u);
    }
}