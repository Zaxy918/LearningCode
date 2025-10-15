#include <cctype>
#include <cstring>
#include <iostream>
#include <string>
using namespace std;

string word;
string line;
int idx = -1;

void lowerStr(string &str) {
    for (char &c : str) {
        if (isalpha(c))
            c = tolower(c);
    }
}

int countSubStr(string line, string word) {
    size_t start = 0;
    size_t end;
    int cnt = 0;
    while ((end = line.find(word, start)) != string::npos) {
        if ((line[end + word.size()] == ' ' || end + word.size() == line.size()) && (line[end - 1] == ' ' || end == 0)) {
            if (cnt == 0)
                idx = end;
            cnt++;
        }
        start = end + word.size();
    }
    return cnt;
}

int main() {
    getline(cin, word);
    getline(cin, line);
    lowerStr(word);
    lowerStr(line);
    int cnt = countSubStr(line, word);
    if (idx == -1)
        cout << -1 << endl;
    else
        cout << cnt << " "
             << idx << endl;
    return 0;
}