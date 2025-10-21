#include <iostream>
using namespace std;

const int MAX_N = 20;

int n;
string votes[MAX_N];
string maxVote = "0";
int id;

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> votes[i];
        maxVote = votes[i].length() == maxVote.length() ? (maxVote > votes[i] ? maxVote : votes[i]) : (maxVote.length() > votes[i].length() ? maxVote : votes[i]);
        id = maxVote == votes[i] ? i + 1 : id;
    }
    cout << id << endl
         << maxVote;
    return 0;
}