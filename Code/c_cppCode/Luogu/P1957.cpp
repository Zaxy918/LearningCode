#include <cstring>
#include <iostream>
#include <string>
#include <vector>
using namespace std;

int i;
char opt;
int a, b;
string expr;

vector<string> split(const string &str, char delimiter) {
    vector<string> tokens;
    size_t start = 0;
    size_t end;
    while ((end = str.find(delimiter, start)) != string::npos) {
        tokens.push_back(str.substr(start, end - start));
        start = end + 1;
    }
    tokens.push_back(str.substr(start));
    return tokens;
}

int main() {
    cin >> i;
    getchar();
    while (i--) {
        string temp;
        getline(cin, temp);
        vector<string> inputs = split(temp, ' ');
        if (inputs.size() == 3) {
            opt = inputs[0][0];
            a = stoi(inputs[1]);
            b = stoi(inputs[2]);
        } else {
            a = stoi(inputs[0]);
            b = stoi(inputs[1]);
        }
        switch (opt) {
        case 'a': {
            string sum = to_string(a + b);
            expr = to_string(a) + "+" + to_string(b) + "=" + sum;
            cout << expr << endl
                 << expr.size() << endl;
        } break;
        case 'b': {
            string sub = to_string(a - b);
            expr = to_string(a) + "-" + to_string(b) + "=" + sub;
            cout << expr << endl
                 << expr.size() << endl;
        } break;
        case 'c': {
            string mul = to_string(a * b);
            expr = to_string(a) + "*" + to_string(b) + "=" + mul;
            cout << expr << endl
                 << expr.size() << endl;
        } break;
        default:
            break;
        }
    }
    return 0;
}