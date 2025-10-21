#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_N = 5001;

int n, m;

struct Applicant {
    int id;
    int score;
} apps[MAX_N];

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> apps[i].id >> apps[i].score;
    }
    sort(apps, apps + n, [](Applicant a, Applicant b) { return a.score == b.score ? a.id < b.id : a.score > b.score; });
    int endScr = apps[int(m * 1.5) - 1].score;
    cout << endScr << " ";
    int idx = 0;
    while (apps[idx].score >= endScr) idx++;
    cout << idx << endl;
    for_each(apps, apps + idx, [](Applicant a) { cout << a.id << " " << a.score << endl; });
    return 0;
}