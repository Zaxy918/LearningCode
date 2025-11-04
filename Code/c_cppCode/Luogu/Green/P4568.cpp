#include <climits>
#include <iostream>
#include <queue>
using namespace std;

const int MAX_N = 1e4 + 1;
const int MAX_M = 2 * 5 * 1e4 + 1;
const int MAX_K = 11;

struct Node {
    int id;
    long long w;
    int st;
    bool operator<(const Node &other) const {
        return this->w > other.w;
    }
};
int n, m, k, s, t;
int limit;
int head[MAX_N];
int nexte[MAX_M];
int to[MAX_M];
long long weight[MAX_M];
int cnt;
Node heap[MAX_N];
int idx[MAX_N];
int heapSize;
long long dis[MAX_N][MAX_K];
bool vis[MAX_N][MAX_K];

bool cmp(Node a, Node b) {
    return a.w > b.w;
}

//* Floating
void heapify(Node node) {
    int cur = idx[node.id]; // Start floating from cur
    int parent = (cur - 1) / 2;
    while (cur > 0 /* Make sure cur is exist */ && cmp(heap[parent], heap[cur])) {
        swap(heap[parent], heap[cur]);
        swap(idx[heap[parent].id], idx[heap[cur].id]);
        cur = parent;
        parent = (cur - 1) / 2;
    }
}

void insert(Node node) {
    heap[heapSize] = node; // Insert is into the end of heap
    idx[heap[heapSize].id] = heapSize;
    heapSize++;
    heapify(node);
}

//* Sinking
Node pop() {
    Node ret = heap[0];
    int cur = 0; // Start from the top
    heap[0] = heap[--heapSize];
    idx[heap[0].id] = 0;
    idx[ret.id] = -2; // The top is deleted from heap, assumming it -2
    int left = cur * 2 + 1;
    while (left < heapSize) {
        int best = left + 1 < heapSize ? (cmp(heap[left], heap[left + 1]) ? (cmp(heap[left + 1], heap[cur]) ? cur : left + 1) : (cmp(heap[cur], heap[left]) ? left : cur)) : (cmp(heap[cur], heap[left]) ? left : cur);
        if (best == cur) break;
        swap(heap[best], heap[cur]);
        swap(idx[heap[best].id], idx[heap[cur].id]);
        cur = best;
        left = cur * 2 + 1;
    }
    return ret;
}

Node top() {
    return heap[0];
}

void addEdge(int u, int v, int w) {
    nexte[++cnt] = head[u];
    head[u] = cnt;
    to[cnt] = v;
    weight[cnt] = w;
}

void init() {
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= k; j++) {
            dis[i][j] = INT_MAX;
        }
    }
    dis[s + 1][0] = 0;
    insert({s + 1, 0, 0});
}

int dijkstra() {
    init();
    while (heapSize) {
        Node cur = pop();
        if (cur.id == t + 1) return cur.w;
        if (!vis[cur.id][cur.st]) {
            vis[cur.id][cur.st] = true;
            for (int i = head[cur.id]; i > 0; i = nexte[i]) {
                if (!vis[to[i]][cur.st] && dis[cur.id][cur.st] + weight[i] < dis[to[i]][cur.st]) {
                    dis[to[i]][cur.st] = dis[cur.id][cur.st] + weight[i];
                    insert({to[i], dis[to[i]][cur.st], cur.st});
                }
                if (cur.st < k) {
                    if (!vis[to[i]][cur.st + 1] && dis[cur.id][cur.st] < dis[to[i]][cur.st + 1]) {
                        dis[to[i]][cur.st + 1] = dis[cur.id][cur.st];
                        insert({to[i], dis[to[i]][cur.st + 1], cur.st + 1});
                    }
                }
            }
        }
    }
    return -1;
}

int main() {
    cin >> n >> m >> k;
    cin >> s >> t;
    for (int i = 0, a, b, c; i < m; i++) {
        cin >> a >> b >> c;
        addEdge(a + 1, b + 1, c);
        addEdge(b + 1, a + 1, c);
    }
    cout << dijkstra() << endl;
    return 0;
}