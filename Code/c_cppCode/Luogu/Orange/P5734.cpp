#include <cstring>
#include <iostream>
#include <limits>
#include <string>
#include <vector>
using namespace std;

int q;
string str;

// vector<string> split(const string &str, char delimiter) {
//     vector<string> tokens;
//     size_t start = 0;
//     size_t end;
//     while ((end = str.find(delimiter, start)) != string::npos) {
//         tokens.push_back(str.substr(start, end - start));
//         start = end + 1;
//     }
//     tokens.push_back(str.substr(start));
//     return tokens;
// }

int main() {
    cin >> q >> str;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    while (q--) {
        string line;
        // vector<string> inputs = split(line, ' ');
        char opt;
        cin >> opt;
        switch (opt) {
        case '1': {
            string temp;
            cin >> temp;
            str += temp;
            cout << str << endl;
        } break;
        case '2': {
            int a, b;
            cin >> a >> b;
            str = str.substr(a, b);
            cout << str << endl;
        } break;
        case '3': {
            int idx;
            string temp;
            cin >> idx >> temp;
            str = str.insert(idx, temp);
            cout << str << endl;
        } break;
        case '4': {
            string temp;
            cin >> temp;
            cout << (int)str.find(temp) << endl;
        } break;
        default:
            break;
        }
    }
}