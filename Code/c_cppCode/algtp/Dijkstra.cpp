// CF20C
#include <climits>
#include <iostream>
using namespace std;

const static int MAX_N = 1e5 + 10;
const static int MAX_M = 2 * MAX_N;

int n, m;
int res[MAX_N];
long long dis[MAX_N];
bool reach;
int pre[MAX_N];
struct Node {
    int id;
    long long w;
};
Node heap[MAX_N];
int heapSize;
int idx[MAX_N];
int head[MAX_N];
int nexte[MAX_M];
int to[MAX_M];
long long weight[MAX_M];
int cnt;

void init() {
    fill(dis + 1, dis + n + 1, LLONG_MAX);
    for (int i = 1; i <= n; i++) {
        idx[i] = -1; // Before adding the node into heap, we assume it -1
    }
}

void addEdge(int u, int v, int w) {
    nexte[++cnt] = head[u];
    head[u] = cnt;
    to[cnt] = v;
    weight[cnt] = w;
}

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

void Dijkstra() {
    init();
    dis[1] = 0;
    insert({1, 0});
    while (heapSize) {
        Node cur = pop();
        int u = cur.id;
        if (u == n) {
            reach = true; // Reach to the end
            return;
        }
        long long curDis;
        for (int i = head[u], v; i > 0; i = nexte[i]) {
            v = to[i];
            curDis = dis[u] + weight[i];
            if (curDis < dis[v]) {
                dis[v] = curDis;
                if (idx[v] == -1) { // Haven't go to heap
                    insert({v, curDis});
                } else if (idx[v] >= 0) { // Aready in the heap
                    heap[idx[v]].w = curDis;
                    heapify(heap[idx[v]]);
                }
                pre[v] = u;
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> m;
    for (int i = 0, u, v, w; i < m; i++) {
        cin >> u >> v >> w;
        addEdge(u, v, w);
        addEdge(v, u, w);
    }
    Dijkstra();
    if (reach) {
        int j = 0;
        for (int i = n; i > 0; i = pre[i], j++) {
            res[j] = i;
        }
        for (int i = j - 1; i >= 0; i--) cout << res[i] << " ";
    } else {
        cout << -1;
    }
    return 0;
}