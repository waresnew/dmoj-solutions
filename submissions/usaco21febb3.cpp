#include <bits/stdc++.h>

// 12/7/2022
using namespace std;
char next_cw(char cur) {
    if (cur=='N') return 'E';
    if (cur=='E') return 'S';
    if (cur=='S') return 'W';
    if (cur=='W') return 'N';
    throw invalid_argument("invalid");
}
char next_ccw(char cur) {
    if (cur=='N') return 'W';
    if (cur=='E') return 'N';
    if (cur=='S') return 'E';
    if (cur=='W') return 'S';
    throw invalid_argument("invalid");
}

char prev_cw(char cur) {
    if (cur=='E') return 'N';
    if (cur=='S') return 'E';
    if (cur=='W') return 'S';
    if (cur=='N') return 'W';
    throw invalid_argument("invalid");
}
char prev_ccw(char cur) {
    if (cur=='W') return 'N';
    if (cur=='N') return 'E';
    if (cur=='E') return 'S';
    if (cur=='S') return 'W';
    throw invalid_argument("invalid");
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int tests;
    cin >> tests;
    for (; tests > 0; tests--) {
        string input;
        cin >> input;
        char prev = input[0];
        string stripped;
        stripped += input[0];
        for (int i = 1; i < input.length();i++) {
            if (prev!=input[i]) {
                stripped += input[i];
            }
            prev = input[i];
        }
        prev=stripped[0];
        int cw=0, ccw=0;
        for (int i = 0; i < stripped.length(); ++i) {
            char cur = stripped[i];
            if (next_cw(prev) == cur) {
                cw++;
            } else if (next_ccw(prev) == cur) {
                ccw++;
            }
            prev = cur;
        }
        cout << (cw>ccw?"CW":"CCW") << "\n";
    }
}