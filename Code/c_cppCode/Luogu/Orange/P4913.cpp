#include <iostream>
#include <vector>
using namespace std;

const int MAX_N = 1e6 + 1;

int n;
struct BinaryTree {
    BinaryTree *left;
    BinaryTree *right;
    int val;
    BinaryTree(int _val) : left(nullptr), right(nullptr), val(_val) {}
};
int lc[MAX_N];
int rc[MAX_N];

int getDepth(BinaryTree *root) {
    if (root == nullptr) return 0;
    return 1 + max(getDepth(root->left), getDepth(root->right));
}

int dfs(int r) {
    if (r == 0) return 0;
    return 1 + max(dfs(lc[r]), dfs(rc[r]));
}

int main() {
    cin >> n;

    for (int i = 1; i <= n; i++) {
        cin >> lc[i] >> rc[i];
    }
    cout << dfs(1);

    vector<BinaryTree *> nodes(n + 1, nullptr);
    for (int i = 1; i <= n; i++) {
        nodes[i] = new BinaryTree(i);
    }
    for (int i = 1, l, r; i <= n; i++) {
        cin >> l >> r;
        if (l != 0) nodes[i]->left = nodes[l];
        if (r != 0) nodes[i]->right = nodes[r];
    }
    cout << getDepth(nodes[1]);
    for (int i = 1; i <= n; i++) {
        delete nodes[i];
    }
    return 0;
}