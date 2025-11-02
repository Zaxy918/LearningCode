#include <iostream>
#include <map>
#include <sstream>
#include <vector>
using namespace std;

string inOrder, preOrder, postOrder;
ostringstream oss;
map<char, int> val2idx;

struct TreeNode {
    TreeNode *left;
    TreeNode *right;
    char val;
    TreeNode(int _val) : left(nullptr), right(nullptr), val(_val) {}
};

TreeNode *parseTree(int ps, int pe, int is, int ie) {
    if (ps == pe || is == ie) return nullptr;
    TreeNode *root = new TreeNode(preOrder[ps]);
    int idx = val2idx[root->val];
    root->left = parseTree(ps + 1, ps + idx - is + 1, is, idx);
    root->right = parseTree(ps + idx - is + 1, pe, idx + 1, ie);
    return root;
}

void postOrderTravaler(TreeNode *root) {
    if (root == nullptr) return;
    postOrderTravaler(root->left);
    postOrderTravaler(root->right);
    oss << root->val;
}

int main() {
    cin >> inOrder >> preOrder;
    int n = inOrder.length();
    for (int i = 0; i < n; i++) {
        val2idx[inOrder[i]] = i;
    }
    TreeNode *root = parseTree(0, n, 0, n);
    postOrderTravaler(root);
    cout << oss.str();
    return 0;
}